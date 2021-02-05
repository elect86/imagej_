/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2014 - 2016 Board of Regents of the University of
 * Wisconsin-Madison, University of Konstanz and Brian Northan.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imagej.ops.math;

import net.imagej.ops.Contingent;
import net.imagej.ops.Ops;
import net.imagej.ops.special.inplace.AbstractUnaryInplaceOp;
import net.imagej.ops.thread.chunker.Chunk;
import net.imagej.ops.thread.chunker.ChunkerOp;
import net.imglib2.img.array.ArrayImg;
import net.imglib2.img.basictypeaccess.array.ByteArray;
import net.imglib2.img.basictypeaccess.array.DoubleArray;
import net.imglib2.img.basictypeaccess.array.FloatArray;
import net.imglib2.img.basictypeaccess.array.IntArray;
import net.imglib2.img.basictypeaccess.array.LongArray;
import net.imglib2.img.basictypeaccess.array.ShortArray;
import net.imglib2.type.numeric.integer.ByteType;
import net.imglib2.type.numeric.integer.IntType;
import net.imglib2.type.numeric.integer.LongType;
import net.imglib2.type.numeric.integer.ShortType;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.type.numeric.integer.UnsignedIntType;
import net.imglib2.type.numeric.integer.UnsignedLongType;
import net.imglib2.type.numeric.integer.UnsignedShortType;
import net.imglib2.type.numeric.real.DoubleType;
import net.imglib2.type.numeric.real.FloatType;

import org.scijava.Priority;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.util.ArrayUtils;

/**
 * Wrapper class for multi-threaded version of binary math operations between 
 * constant values and {@link ArrayImg}s.
 * <p>
 * Add, subtract, multiply, and divide are implemented for {@link ArrayImg}s
 * of {@link ByteType} or {@link DoubleType}.
 * </p>
 *
 * @author Leon Yang
 */
public final class ConstantToArrayImageP {

	private ConstantToArrayImageP() {
		// NB: Prevent instantiation of utility class.
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link ByteType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddByte extends
		AbstractUnaryInplaceOp<ArrayImg<ByteType, ByteArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<ByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ByteType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link ByteType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractByte extends
		AbstractUnaryInplaceOp<ArrayImg<ByteType, ByteArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<ByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ByteType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link ByteType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyByte extends
		AbstractUnaryInplaceOp<ArrayImg<ByteType, ByteArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<ByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ByteType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link ByteType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideByte extends
		AbstractUnaryInplaceOp<ArrayImg<ByteType, ByteArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<ByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ByteType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link IntType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddInt extends
		AbstractUnaryInplaceOp<ArrayImg<IntType, IntArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<IntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof IntType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link IntType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractInt extends
		AbstractUnaryInplaceOp<ArrayImg<IntType, IntArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<IntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof IntType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link IntType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyInt extends
		AbstractUnaryInplaceOp<ArrayImg<IntType, IntArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<IntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof IntType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link IntType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideInt extends
		AbstractUnaryInplaceOp<ArrayImg<IntType, IntArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<IntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof IntType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link LongType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddLong extends
		AbstractUnaryInplaceOp<ArrayImg<LongType, LongArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<LongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof LongType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link LongType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractLong extends
		AbstractUnaryInplaceOp<ArrayImg<LongType, LongArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<LongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof LongType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link LongType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyLong extends
		AbstractUnaryInplaceOp<ArrayImg<LongType, LongArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<LongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof LongType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link LongType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideLong extends
		AbstractUnaryInplaceOp<ArrayImg<LongType, LongArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<LongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof LongType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link ShortType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddShort extends
		AbstractUnaryInplaceOp<ArrayImg<ShortType, ShortArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<ShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ShortType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link ShortType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractShort extends
		AbstractUnaryInplaceOp<ArrayImg<ShortType, ShortArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<ShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ShortType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link ShortType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyShort extends
		AbstractUnaryInplaceOp<ArrayImg<ShortType, ShortArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<ShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ShortType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link ShortType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideShort extends
		AbstractUnaryInplaceOp<ArrayImg<ShortType, ShortArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<ShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ShortType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link FloatType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddFloat extends
		AbstractUnaryInplaceOp<ArrayImg<FloatType, FloatArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final ArrayImg<FloatType, FloatArray> arg) {
			final float[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof FloatType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link FloatType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractFloat extends
		AbstractUnaryInplaceOp<ArrayImg<FloatType, FloatArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final ArrayImg<FloatType, FloatArray> arg) {
			final float[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof FloatType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link FloatType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyFloat extends
		AbstractUnaryInplaceOp<ArrayImg<FloatType, FloatArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final ArrayImg<FloatType, FloatArray> arg) {
			final float[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof FloatType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link FloatType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideFloat extends
		AbstractUnaryInplaceOp<ArrayImg<FloatType, FloatArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final ArrayImg<FloatType, FloatArray> arg) {
			final float[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof FloatType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link DoubleType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddDouble extends
		AbstractUnaryInplaceOp<ArrayImg<DoubleType, DoubleArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final ArrayImg<DoubleType, DoubleArray> arg) {
			final double[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof DoubleType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link DoubleType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractDouble extends
		AbstractUnaryInplaceOp<ArrayImg<DoubleType, DoubleArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final ArrayImg<DoubleType, DoubleArray> arg) {
			final double[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof DoubleType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link DoubleType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyDouble extends
		AbstractUnaryInplaceOp<ArrayImg<DoubleType, DoubleArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final ArrayImg<DoubleType, DoubleArray> arg) {
			final double[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof DoubleType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link DoubleType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideDouble extends
		AbstractUnaryInplaceOp<ArrayImg<DoubleType, DoubleArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final ArrayImg<DoubleType, DoubleArray> arg) {
			final double[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof DoubleType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link UnsignedByteType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddUnsignedByte extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedByteType, ByteArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<UnsignedByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedByteType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link UnsignedByteType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractUnsignedByte extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedByteType, ByteArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<UnsignedByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedByteType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link UnsignedByteType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyUnsignedByte extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedByteType, ByteArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<UnsignedByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedByteType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link UnsignedByteType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideUnsignedByte extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedByteType, ByteArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<UnsignedByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedByteType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link UnsignedIntType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddUnsignedInt extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedIntType, IntArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<UnsignedIntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedIntType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link UnsignedIntType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractUnsignedInt extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedIntType, IntArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<UnsignedIntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedIntType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link UnsignedIntType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyUnsignedInt extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedIntType, IntArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<UnsignedIntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedIntType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link UnsignedIntType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideUnsignedInt extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedIntType, IntArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<UnsignedIntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedIntType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link UnsignedLongType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddUnsignedLong extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedLongType, LongArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<UnsignedLongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedLongType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link UnsignedLongType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractUnsignedLong extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedLongType, LongArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<UnsignedLongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedLongType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link UnsignedLongType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyUnsignedLong extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedLongType, LongArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<UnsignedLongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedLongType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link UnsignedLongType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideUnsignedLong extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedLongType, LongArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<UnsignedLongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedLongType;
		}
	}

	/**
	 * Multi-threaded version of optimized add constant for {@link ArrayImg}s of
	 * type {@link UnsignedShortType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH + 1)
	public static class AddUnsignedShort extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedShortType, ShortArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<UnsignedShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] += value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] += value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedShortType;
		}
	}

	/**
	 * Multi-threaded version of optimized subtract constant from {@link ArrayImg}s of
	 * type {@link UnsignedShortType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH + 1)
	public static class SubtractUnsignedShort extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedShortType, ShortArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<UnsignedShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] -= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] -= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedShortType;
		}
	}

	/**
	 * Multi-threaded version of optimized multiply constant for {@link ArrayImg}s of
	 * type {@link UnsignedShortType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH + 1)
	public static class MultiplyUnsignedShort extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedShortType, ShortArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<UnsignedShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] *= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] *= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedShortType;
		}
	}

	/**
	 * Multi-threaded version of optimized divide constant from {@link ArrayImg}s of
	 * type {@link UnsignedShortType}
	 * 
	 * @author Christian Dietz (University of Konstanz)
	 */
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH + 1)
	public static class DivideUnsignedShort extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedShortType, ShortArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<UnsignedShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			ops().run(ChunkerOp.class, new Chunk() {

				@Override
				public void execute(final long startIndex, final long stepSize,
						final long numSteps) {
					
					final int startIndexSafe32 = (startIndex==0) ? 0 : ArrayUtils.safeMultiply32(startIndex);
					final int stepSizeSafe32 = (stepSize==0) ? 0 : ArrayUtils.safeMultiply32(stepSize);
					
					if (stepSizeSafe32 != 1) {					
						for (int i = startIndexSafe32, j = 0; j < numSteps; i = i
								+ stepSizeSafe32, j++) {
							data[i] /= value;
						}
					} else {
						for (int i = startIndexSafe32; i < startIndex + numSteps; i++) {
							data[i] /= value;
						}
					}
				}
			}, data.length);
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedShortType;
		}
	}
}
