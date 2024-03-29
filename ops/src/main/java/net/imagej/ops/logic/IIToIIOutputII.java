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

package net.imagej.ops.logic;

import net.imagej.ops.Contingent;
import net.imagej.ops.Op;
import net.imagej.ops.Ops;
import net.imagej.ops.map.Maps;
import net.imagej.ops.special.computer.BinaryComputerOp;
import net.imagej.ops.special.computer.Computers;
import net.imagej.ops.special.function.Functions;
import net.imagej.ops.special.function.UnaryFunctionOp;
import net.imagej.ops.special.hybrid.AbstractBinaryHybridCFI;
import net.imagej.ops.special.hybrid.Hybrids;
import net.imagej.ops.special.inplace.BinaryInplaceOp;
import net.imagej.ops.special.inplace.Inplaces;
import net.imglib2.IterableInterval;
import net.imglib2.type.BooleanType;

import org.scijava.plugin.Plugin;

/**
 * Wrapper class for binary logic operations between {@link IterableInterval}s
 * and writes result to {@link IterableInterval}s. 
 *
 * @author Leon Yang
 */
public final class IIToIIOutputII {
	
	private IIToIIOutputII() {
		// NB: Prevent instantiation of utility class.
	}
	
	@Plugin(type = Ops.Logic.And.class)
	public static class And<T extends BooleanType<T>> extends
		AbstractBinaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Ops.Logic.And, Contingent
	{

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;
		private BinaryComputerOp<IterableInterval<T>, IterableInterval<T>, IterableInterval<T>> mapper;
		private BinaryInplaceOp<? super IterableInterval<T>, IterableInterval<T>> inplaceMapper;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in1(), in1().firstElement()
					.createVariable());
			if (out() == null) setOutput(createOutput());
			final Op op = Hybrids.binaryCI(ops(), Ops.Logic.And.class, BooleanType.class, BooleanType.class);
			mapper = Computers.binary(ops(), Ops.Map.class, out(), in1(), in2(), op);
			inplaceMapper = Inplaces.binary(ops(), Ops.Map.class, in1(), in2(), op);
		}

		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public IterableInterval<T> createOutput(final IterableInterval<T> input1,
			final IterableInterval<T> input2)
		{
			return outputCreator.calculate(input1);
		}

		@Override
		public void compute(final IterableInterval<T> input1,
			final IterableInterval<T> input2, final IterableInterval<T> output)
		{
			mapper.compute(input1, input2, output);
		}

		@Override
		public void mutate1(final IterableInterval<T> arg,
			final IterableInterval<T> in)
		{
			inplaceMapper.mutate1(arg, in);
		}

		@Override
		public void mutate2(final IterableInterval<T> in,
			final IterableInterval<T> arg)
		{
			inplaceMapper.mutate2(in, arg);
		}
	}
	
	@Plugin(type = Ops.Logic.Or.class)
	public static class Or<T extends BooleanType<T>> extends
		AbstractBinaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Ops.Logic.Or, Contingent
	{

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;
		private BinaryComputerOp<IterableInterval<T>, IterableInterval<T>, IterableInterval<T>> mapper;
		private BinaryInplaceOp<? super IterableInterval<T>, IterableInterval<T>> inplaceMapper;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in1(), in1().firstElement()
					.createVariable());
			if (out() == null) setOutput(createOutput());
			final Op op = Hybrids.binaryCI(ops(), Ops.Logic.Or.class, BooleanType.class, BooleanType.class);
			mapper = Computers.binary(ops(), Ops.Map.class, out(), in1(), in2(), op);
			inplaceMapper = Inplaces.binary(ops(), Ops.Map.class, in1(), in2(), op);
		}

		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public IterableInterval<T> createOutput(final IterableInterval<T> input1,
			final IterableInterval<T> input2)
		{
			return outputCreator.calculate(input1);
		}

		@Override
		public void compute(final IterableInterval<T> input1,
			final IterableInterval<T> input2, final IterableInterval<T> output)
		{
			mapper.compute(input1, input2, output);
		}

		@Override
		public void mutate1(final IterableInterval<T> arg,
			final IterableInterval<T> in)
		{
			inplaceMapper.mutate1(arg, in);
		}

		@Override
		public void mutate2(final IterableInterval<T> in,
			final IterableInterval<T> arg)
		{
			inplaceMapper.mutate2(in, arg);
		}
	}
	
	@Plugin(type = Ops.Logic.Xor.class)
	public static class Xor<T extends BooleanType<T>> extends
		AbstractBinaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Ops.Logic.Xor, Contingent
	{

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;
		private BinaryComputerOp<IterableInterval<T>, IterableInterval<T>, IterableInterval<T>> mapper;
		private BinaryInplaceOp<? super IterableInterval<T>, IterableInterval<T>> inplaceMapper;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in1(), in1().firstElement()
					.createVariable());
			if (out() == null) setOutput(createOutput());
			final Op op = Hybrids.binaryCI(ops(), Ops.Logic.Xor.class, BooleanType.class, BooleanType.class);
			mapper = Computers.binary(ops(), Ops.Map.class, out(), in1(), in2(), op);
			inplaceMapper = Inplaces.binary(ops(), Ops.Map.class, in1(), in2(), op);
		}

		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public IterableInterval<T> createOutput(final IterableInterval<T> input1,
			final IterableInterval<T> input2)
		{
			return outputCreator.calculate(input1);
		}

		@Override
		public void compute(final IterableInterval<T> input1,
			final IterableInterval<T> input2, final IterableInterval<T> output)
		{
			mapper.compute(input1, input2, output);
		}

		@Override
		public void mutate1(final IterableInterval<T> arg,
			final IterableInterval<T> in)
		{
			inplaceMapper.mutate1(arg, in);
		}

		@Override
		public void mutate2(final IterableInterval<T> in,
			final IterableInterval<T> arg)
		{
			inplaceMapper.mutate2(in, arg);
		}
	}
}
