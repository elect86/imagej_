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
import net.imglib2.img.basictypeaccess.array.ByteArray;
import net.imglib2.img.basictypeaccess.array.DoubleArray;
import net.imglib2.img.basictypeaccess.array.FloatArray;
import net.imglib2.img.basictypeaccess.array.IntArray;
import net.imglib2.img.basictypeaccess.array.LongArray;
import net.imglib2.img.basictypeaccess.array.ShortArray;
import net.imglib2.img.planar.PlanarImg;
import net.imglib2.type.numeric.integer.IntType;
import net.imglib2.type.numeric.integer.ByteType;
import net.imglib2.type.numeric.integer.LongType;
import net.imglib2.type.numeric.integer.ShortType;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.type.numeric.integer.UnsignedIntType;
import net.imglib2.type.numeric.integer.UnsignedLongType;
import net.imglib2.type.numeric.integer.UnsignedShortType;
import net.imglib2.type.numeric.real.DoubleType;
import net.imglib2.type.numeric.real.FloatType;

import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

/**
 * Wrapper class for binary math operations between constant values and {@link PlanarImg}s.
 * <p>
 * Add, subtract, multiply, and divide are implemented for {@link PlanarImg}s
 * of {@link DoubleType}.
 * </p>
 *
 * @author Leon Yang
 */
public final class ConstantToPlanarImage {
	
	private ConstantToPlanarImage() {
		// NB: Prevent instantiation of utility class.
	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddByte extends
		AbstractUnaryInplaceOp<PlanarImg<ByteType, ByteArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final PlanarImg<ByteType, ByteArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final byte[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ByteType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractByte extends
		AbstractUnaryInplaceOp<PlanarImg<ByteType, ByteArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final PlanarImg<ByteType, ByteArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final byte[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ByteType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyByte extends
		AbstractUnaryInplaceOp<PlanarImg<ByteType, ByteArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final PlanarImg<ByteType, ByteArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final byte[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ByteType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideByte extends
		AbstractUnaryInplaceOp<PlanarImg<ByteType, ByteArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final PlanarImg<ByteType, ByteArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final byte[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ByteType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddInt extends
		AbstractUnaryInplaceOp<PlanarImg<IntType, IntArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final PlanarImg<IntType, IntArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final int[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof IntType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractInt extends
		AbstractUnaryInplaceOp<PlanarImg<IntType, IntArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final PlanarImg<IntType, IntArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final int[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof IntType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyInt extends
		AbstractUnaryInplaceOp<PlanarImg<IntType, IntArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final PlanarImg<IntType, IntArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final int[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof IntType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideInt extends
		AbstractUnaryInplaceOp<PlanarImg<IntType, IntArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final PlanarImg<IntType, IntArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final int[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof IntType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddLong extends
		AbstractUnaryInplaceOp<PlanarImg<LongType, LongArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final PlanarImg<LongType, LongArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final long[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof LongType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractLong extends
		AbstractUnaryInplaceOp<PlanarImg<LongType, LongArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final PlanarImg<LongType, LongArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final long[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof LongType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyLong extends
		AbstractUnaryInplaceOp<PlanarImg<LongType, LongArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final PlanarImg<LongType, LongArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final long[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof LongType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideLong extends
		AbstractUnaryInplaceOp<PlanarImg<LongType, LongArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final PlanarImg<LongType, LongArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final long[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof LongType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddShort extends
		AbstractUnaryInplaceOp<PlanarImg<ShortType, ShortArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final PlanarImg<ShortType, ShortArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final short[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ShortType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractShort extends
		AbstractUnaryInplaceOp<PlanarImg<ShortType, ShortArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final PlanarImg<ShortType, ShortArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final short[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ShortType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyShort extends
		AbstractUnaryInplaceOp<PlanarImg<ShortType, ShortArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final PlanarImg<ShortType, ShortArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final short[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ShortType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideShort extends
		AbstractUnaryInplaceOp<PlanarImg<ShortType, ShortArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final PlanarImg<ShortType, ShortArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final short[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof ShortType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddFloat extends
		AbstractUnaryInplaceOp<PlanarImg<FloatType, FloatArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final PlanarImg<FloatType, FloatArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final float[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof FloatType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractFloat extends
		AbstractUnaryInplaceOp<PlanarImg<FloatType, FloatArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final PlanarImg<FloatType, FloatArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final float[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof FloatType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyFloat extends
		AbstractUnaryInplaceOp<PlanarImg<FloatType, FloatArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final PlanarImg<FloatType, FloatArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final float[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof FloatType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideFloat extends
		AbstractUnaryInplaceOp<PlanarImg<FloatType, FloatArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final PlanarImg<FloatType, FloatArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final float[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof FloatType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddDouble extends
		AbstractUnaryInplaceOp<PlanarImg<DoubleType, DoubleArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final PlanarImg<DoubleType, DoubleArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final double[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof DoubleType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractDouble extends
		AbstractUnaryInplaceOp<PlanarImg<DoubleType, DoubleArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final PlanarImg<DoubleType, DoubleArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final double[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof DoubleType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyDouble extends
		AbstractUnaryInplaceOp<PlanarImg<DoubleType, DoubleArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final PlanarImg<DoubleType, DoubleArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final double[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof DoubleType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideDouble extends
		AbstractUnaryInplaceOp<PlanarImg<DoubleType, DoubleArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final PlanarImg<DoubleType, DoubleArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final double[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof DoubleType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddUnsignedByte extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedByteType, ByteArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final PlanarImg<UnsignedByteType, ByteArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final byte[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedByteType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractUnsignedByte extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedByteType, ByteArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final PlanarImg<UnsignedByteType, ByteArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final byte[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedByteType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyUnsignedByte extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedByteType, ByteArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final PlanarImg<UnsignedByteType, ByteArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final byte[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedByteType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideUnsignedByte extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedByteType, ByteArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final PlanarImg<UnsignedByteType, ByteArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final byte[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedByteType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddUnsignedInt extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedIntType, IntArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final PlanarImg<UnsignedIntType, IntArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final int[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedIntType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractUnsignedInt extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedIntType, IntArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final PlanarImg<UnsignedIntType, IntArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final int[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedIntType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyUnsignedInt extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedIntType, IntArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final PlanarImg<UnsignedIntType, IntArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final int[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedIntType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideUnsignedInt extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedIntType, IntArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final PlanarImg<UnsignedIntType, IntArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final int[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedIntType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddUnsignedLong extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedLongType, LongArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final PlanarImg<UnsignedLongType, LongArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final long[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedLongType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractUnsignedLong extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedLongType, LongArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final PlanarImg<UnsignedLongType, LongArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final long[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedLongType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyUnsignedLong extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedLongType, LongArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final PlanarImg<UnsignedLongType, LongArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final long[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedLongType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideUnsignedLong extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedLongType, LongArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final PlanarImg<UnsignedLongType, LongArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final long[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedLongType;
		}

	}
	
	@Plugin(type = Ops.Math.Add.class)
	public static class AddUnsignedShort extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedShortType, ShortArray>> implements Ops.Math.Add,
		Contingent
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final PlanarImg<UnsignedShortType, ShortArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final short[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] += value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedShortType;
		}

	}
	
	@Plugin(type = Ops.Math.Subtract.class)
	public static class SubtractUnsignedShort extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedShortType, ShortArray>> implements Ops.Math.Subtract,
		Contingent
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final PlanarImg<UnsignedShortType, ShortArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final short[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] -= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedShortType;
		}

	}
	
	@Plugin(type = Ops.Math.Multiply.class)
	public static class MultiplyUnsignedShort extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedShortType, ShortArray>> implements Ops.Math.Multiply,
		Contingent
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final PlanarImg<UnsignedShortType, ShortArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final short[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] *= value;
				}
			}
		}

		@Override
		public boolean conforms() {
			// NB: Until https://github.com/imagej/imagej-ops/issues/95 is addressed.
			// The warning is expected, because the image parameter is assigned via
			// reflection and hence might not match the declared generic types.
			return in().firstElement() instanceof UnsignedShortType;
		}

	}
	
	@Plugin(type = Ops.Math.Divide.class)
	public static class DivideUnsignedShort extends
		AbstractUnaryInplaceOp<PlanarImg<UnsignedShortType, ShortArray>> implements Ops.Math.Divide,
		Contingent
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final PlanarImg<UnsignedShortType, ShortArray> arg) {
			long planeCount = 1;
			for (int d = 2; d < arg.numDimensions(); d++) {
				planeCount *= arg.dimension(d);
			}
			for (int p = 0; p < planeCount; p++) {
				final short[] plane = arg.getPlane(p).getCurrentStorageArray();
				for (int i = 0; i < plane.length; i++) {
					plane[i] /= value;
				}
			}
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
