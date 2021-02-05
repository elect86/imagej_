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

/**
 * Wrapper class for binary math operations between constant values and {@link ArrayImg}s.
 * <p>
 * Add, subtract, multiply, and divide are implemented for {@link ArrayImg}s
 * of {@link ByteType} or {@link DoubleType}.
 * </p>
 *
 * @author Leon Yang
 */
public final class ConstantToArrayImage {
	private ConstantToArrayImage() {
		// NB: Prevent instantiation of utility class.
	}

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddByte extends
		AbstractUnaryInplaceOp<ArrayImg<ByteType, ByteArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<ByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractByte extends
		AbstractUnaryInplaceOp<ArrayImg<ByteType, ByteArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<ByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyByte extends
		AbstractUnaryInplaceOp<ArrayImg<ByteType, ByteArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<ByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideByte extends
		AbstractUnaryInplaceOp<ArrayImg<ByteType, ByteArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<ByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddInt extends
		AbstractUnaryInplaceOp<ArrayImg<IntType, IntArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<IntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractInt extends
		AbstractUnaryInplaceOp<ArrayImg<IntType, IntArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<IntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyInt extends
		AbstractUnaryInplaceOp<ArrayImg<IntType, IntArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<IntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideInt extends
		AbstractUnaryInplaceOp<ArrayImg<IntType, IntArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<IntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddLong extends
		AbstractUnaryInplaceOp<ArrayImg<LongType, LongArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<LongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractLong extends
		AbstractUnaryInplaceOp<ArrayImg<LongType, LongArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<LongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyLong extends
		AbstractUnaryInplaceOp<ArrayImg<LongType, LongArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<LongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideLong extends
		AbstractUnaryInplaceOp<ArrayImg<LongType, LongArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<LongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddShort extends
		AbstractUnaryInplaceOp<ArrayImg<ShortType, ShortArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<ShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractShort extends
		AbstractUnaryInplaceOp<ArrayImg<ShortType, ShortArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<ShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyShort extends
		AbstractUnaryInplaceOp<ArrayImg<ShortType, ShortArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<ShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideShort extends
		AbstractUnaryInplaceOp<ArrayImg<ShortType, ShortArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<ShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddFloat extends
		AbstractUnaryInplaceOp<ArrayImg<FloatType, FloatArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final ArrayImg<FloatType, FloatArray> arg) {
			final float[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractFloat extends
		AbstractUnaryInplaceOp<ArrayImg<FloatType, FloatArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final ArrayImg<FloatType, FloatArray> arg) {
			final float[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyFloat extends
		AbstractUnaryInplaceOp<ArrayImg<FloatType, FloatArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final ArrayImg<FloatType, FloatArray> arg) {
			final float[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideFloat extends
		AbstractUnaryInplaceOp<ArrayImg<FloatType, FloatArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private float value;

		@Override
		public void mutate(final ArrayImg<FloatType, FloatArray> arg) {
			final float[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddDouble extends
		AbstractUnaryInplaceOp<ArrayImg<DoubleType, DoubleArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final ArrayImg<DoubleType, DoubleArray> arg) {
			final double[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractDouble extends
		AbstractUnaryInplaceOp<ArrayImg<DoubleType, DoubleArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final ArrayImg<DoubleType, DoubleArray> arg) {
			final double[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyDouble extends
		AbstractUnaryInplaceOp<ArrayImg<DoubleType, DoubleArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final ArrayImg<DoubleType, DoubleArray> arg) {
			final double[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideDouble extends
		AbstractUnaryInplaceOp<ArrayImg<DoubleType, DoubleArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private double value;

		@Override
		public void mutate(final ArrayImg<DoubleType, DoubleArray> arg) {
			final double[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddUnsignedByte extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedByteType, ByteArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<UnsignedByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractUnsignedByte extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedByteType, ByteArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<UnsignedByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyUnsignedByte extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedByteType, ByteArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<UnsignedByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideUnsignedByte extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedByteType, ByteArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private byte value;

		@Override
		public void mutate(final ArrayImg<UnsignedByteType, ByteArray> arg) {
			final byte[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddUnsignedInt extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedIntType, IntArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<UnsignedIntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractUnsignedInt extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedIntType, IntArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<UnsignedIntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyUnsignedInt extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedIntType, IntArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<UnsignedIntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideUnsignedInt extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedIntType, IntArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private int value;

		@Override
		public void mutate(final ArrayImg<UnsignedIntType, IntArray> arg) {
			final int[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddUnsignedLong extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedLongType, LongArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<UnsignedLongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractUnsignedLong extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedLongType, LongArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<UnsignedLongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyUnsignedLong extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedLongType, LongArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<UnsignedLongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideUnsignedLong extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedLongType, LongArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private long value;

		@Override
		public void mutate(final ArrayImg<UnsignedLongType, LongArray> arg) {
			final long[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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

	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class AddUnsignedShort extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedShortType, ShortArray>> implements Contingent,
		Ops.Math.Add
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<UnsignedShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] += value;
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

	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class SubtractUnsignedShort extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedShortType, ShortArray>> implements Contingent,
		Ops.Math.Subtract
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<UnsignedShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] -= value;
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

	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class MultiplyUnsignedShort extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedShortType, ShortArray>> implements Contingent,
		Ops.Math.Multiply
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<UnsignedShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] *= value;
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

	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class DivideUnsignedShort extends
		AbstractUnaryInplaceOp<ArrayImg<UnsignedShortType, ShortArray>> implements Contingent,
		Ops.Math.Divide
	{

		@Parameter
		private short value;

		@Override
		public void mutate(final ArrayImg<UnsignedShortType, ShortArray> arg) {
			final short[] data = arg.update(null).getCurrentStorageArray();
			for (int i = 0; i < data.length; i++) {
				data[i] /= value;
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
