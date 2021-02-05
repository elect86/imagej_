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

package net.imagej.ops.convert;

import net.imagej.ops.Op;
import net.imagej.ops.Ops;
import net.imagej.ops.special.chain.UHCFViaUCSameIO;
import net.imagej.ops.special.computer.Computers;
import net.imagej.ops.special.computer.UnaryComputerOp;
import net.imglib2.IterableInterval;
import net.imglib2.img.Img;
import net.imglib2.type.NativeType;
import net.imglib2.type.numeric.ComplexType;

import net.imglib2.type.logic.BitType;
import net.imglib2.type.numeric.complex.ComplexDoubleType;
import net.imglib2.type.numeric.complex.ComplexFloatType;
import net.imglib2.type.numeric.integer.ByteType;
import net.imglib2.type.numeric.integer.IntType;
import net.imglib2.type.numeric.integer.LongType;
import net.imglib2.type.numeric.integer.ShortType;
import net.imglib2.type.numeric.integer.Unsigned128BitType;
import net.imglib2.type.numeric.integer.Unsigned12BitType;
import net.imglib2.type.numeric.integer.Unsigned2BitType;
import net.imglib2.type.numeric.integer.Unsigned4BitType;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.type.numeric.integer.UnsignedIntType;
import net.imglib2.type.numeric.integer.UnsignedLongType;
import net.imglib2.type.numeric.integer.UnsignedShortType;
import net.imglib2.type.numeric.real.DoubleType;
import net.imglib2.type.numeric.real.FloatType;

import org.scijava.plugin.Plugin;

/**
 * Ops for converting images between types.
 * <p>
 * These ops work by feeding the {@link ConvertTypes} ops to {@code map}.
 * </p>
 *
 * @author Curtis Rueden
 */
public final class ConvertImages {

	private ConvertImages() {
		// NB: Prevent instantiation of utility class.
	}

	@Plugin(type = Ops.Convert.Bit.class)
	public static class Bit<C extends ComplexType<C>> extends
		ConvertViaMap<C, BitType> implements
		Ops.Convert.Bit
	{
		public Bit() {
			super(Ops.Convert.Bit.class, new BitType());
		}
	}

	@Plugin(type = Ops.Convert.Uint2.class)
	public static class Uint2<C extends ComplexType<C>> extends
		ConvertViaMap<C, Unsigned2BitType> implements
		Ops.Convert.Uint2
	{
		public Uint2() {
			super(Ops.Convert.Uint2.class, new Unsigned2BitType());
		}
	}

	@Plugin(type = Ops.Convert.Uint4.class)
	public static class Uint4<C extends ComplexType<C>> extends
		ConvertViaMap<C, Unsigned4BitType> implements
		Ops.Convert.Uint4
	{
		public Uint4() {
			super(Ops.Convert.Uint4.class, new Unsigned4BitType());
		}
	}

	@Plugin(type = Ops.Convert.Int8.class)
	public static class Int8<C extends ComplexType<C>> extends
		ConvertViaMap<C, ByteType> implements
		Ops.Convert.Int8
	{
		public Int8() {
			super(Ops.Convert.Int8.class, new ByteType());
		}
	}

	@Plugin(type = Ops.Convert.Uint8.class)
	public static class Uint8<C extends ComplexType<C>> extends
		ConvertViaMap<C, UnsignedByteType> implements
		Ops.Convert.Uint8
	{
		public Uint8() {
			super(Ops.Convert.Uint8.class, new UnsignedByteType());
		}
	}

	@Plugin(type = Ops.Convert.Uint12.class)
	public static class Uint12<C extends ComplexType<C>> extends
		ConvertViaMap<C, Unsigned12BitType> implements
		Ops.Convert.Uint12
	{
		public Uint12() {
			super(Ops.Convert.Uint12.class, new Unsigned12BitType());
		}
	}

	@Plugin(type = Ops.Convert.Int16.class)
	public static class Int16<C extends ComplexType<C>> extends
		ConvertViaMap<C, ShortType> implements
		Ops.Convert.Int16
	{
		public Int16() {
			super(Ops.Convert.Int16.class, new ShortType());
		}
	}

	@Plugin(type = Ops.Convert.Uint16.class)
	public static class Uint16<C extends ComplexType<C>> extends
		ConvertViaMap<C, UnsignedShortType> implements
		Ops.Convert.Uint16
	{
		public Uint16() {
			super(Ops.Convert.Uint16.class, new UnsignedShortType());
		}
	}

	@Plugin(type = Ops.Convert.Int32.class)
	public static class Int32<C extends ComplexType<C>> extends
		ConvertViaMap<C, IntType> implements
		Ops.Convert.Int32
	{
		public Int32() {
			super(Ops.Convert.Int32.class, new IntType());
		}
	}

	@Plugin(type = Ops.Convert.Uint32.class)
	public static class Uint32<C extends ComplexType<C>> extends
		ConvertViaMap<C, UnsignedIntType> implements
		Ops.Convert.Uint32
	{
		public Uint32() {
			super(Ops.Convert.Uint32.class, new UnsignedIntType());
		}
	}

	@Plugin(type = Ops.Convert.Int64.class)
	public static class Int64<C extends ComplexType<C>> extends
		ConvertViaMap<C, LongType> implements
		Ops.Convert.Int64
	{
		public Int64() {
			super(Ops.Convert.Int64.class, new LongType());
		}
	}

	@Plugin(type = Ops.Convert.Uint64.class)
	public static class Uint64<C extends ComplexType<C>> extends
		ConvertViaMap<C, UnsignedLongType> implements
		Ops.Convert.Uint64
	{
		public Uint64() {
			super(Ops.Convert.Uint64.class, new UnsignedLongType());
		}
	}

	@Plugin(type = Ops.Convert.Uint128.class)
	public static class Uint128<C extends ComplexType<C>> extends
		ConvertViaMap<C, Unsigned128BitType> implements
		Ops.Convert.Uint128
	{
		public Uint128() {
			super(Ops.Convert.Uint128.class, new Unsigned128BitType());
		}
	}

	@Plugin(type = Ops.Convert.Float32.class)
	public static class Float32<C extends ComplexType<C>> extends
		ConvertViaMap<C, FloatType> implements
		Ops.Convert.Float32
	{
		public Float32() {
			super(Ops.Convert.Float32.class, new FloatType());
		}
	}

	@Plugin(type = Ops.Convert.Float64.class)
	public static class Float64<C extends ComplexType<C>> extends
		ConvertViaMap<C, DoubleType> implements
		Ops.Convert.Float64
	{
		public Float64() {
			super(Ops.Convert.Float64.class, new DoubleType());
		}
	}

	@Plugin(type = Ops.Convert.Cfloat32.class)
	public static class Cfloat32<C extends ComplexType<C>> extends
		ConvertViaMap<C, ComplexFloatType> implements
		Ops.Convert.Cfloat32
	{
		public Cfloat32() {
			super(Ops.Convert.Cfloat32.class, new ComplexFloatType());
		}
	}

	@Plugin(type = Ops.Convert.Cfloat64.class)
	public static class Cfloat64<C extends ComplexType<C>> extends
		ConvertViaMap<C, ComplexDoubleType> implements
		Ops.Convert.Cfloat64
	{
		public Cfloat64() {
			super(Ops.Convert.Cfloat64.class, new ComplexDoubleType());
		}
	}

	// -- Helper classes --

	private abstract static class ConvertViaMap<I extends ComplexType<I>, O extends NativeType<O>>
		extends UHCFViaUCSameIO<IterableInterval<I>, Img<O>>
	{

		private Class<? extends Op> opType;
		private O outElement;

		protected ConvertViaMap(Class<? extends Op> opType, O outElement) {
			this.opType = opType;
			this.outElement = outElement;
		}

		@Override
		public UnaryComputerOp<IterableInterval<I>, Img<O>> createWorker(
			final IterableInterval<I> t)
		{
			final I inElement = t.firstElement();
			final UnaryComputerOp<I, O> elementOp = Computers.unary(ops(), opType,
				outElement, inElement);
			return (UnaryComputerOp)
				Computers.unary(ops(), Ops.Map.class, Img.class, t, elementOp);
		}

		@Override
		public Img<O> createOutput(final IterableInterval<I> input) {
			return ops().create().img(input, outElement);
		}
	}

}
