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
import net.imagej.ops.special.function.Functions;
import net.imagej.ops.special.function.UnaryFunctionOp;
import net.imagej.ops.special.hybrid.AbstractBinaryHybridCFI;
import net.imglib2.Cursor;
import net.imglib2.IterableInterval;
import net.imglib2.type.numeric.NumericType;
import net.imglib2.util.Intervals;

import org.scijava.Priority;
import org.scijava.plugin.Plugin;

/**
 * Wrapper class for binary math operations between {@link IterableInterval}s
 * and write result to {@link IterableInterval}s. 
 *
 * @author Leon Yang
 */
public final class IIToIIOutputII {
	
	private IIToIIOutputII() {
		// NB: Prevent instantiation of utility class.
	}
	
	@Plugin(type = Ops.Math.Add.class, priority = Priority.HIGH)
	public static class Add<T extends NumericType<T>> extends
		AbstractBinaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Ops.Math.Add, Contingent
	{

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in1(), in1().firstElement()
					.createVariable());
		}

		// TODO: extend common abstract base class which implements Contingent
		// for dimensionality checking.

		@Override
		public boolean conforms() {
			if (!Intervals.equalDimensions(in1(), in2())) return false;
			if (!in1().iterationOrder().equals(in2().iterationOrder())) return false;
			if (out() == null) return true;
			return Intervals.equalDimensions(in1(), out()) && in1().iterationOrder()
				.equals(out().iterationOrder());
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
			final Cursor<T> in1Cursor = input1.cursor();
			final Cursor<T> in2Cursor = input2.cursor();
			final Cursor<T> outCursor = output.cursor();
			while (in1Cursor.hasNext()) {
				outCursor.next().set(in1Cursor.next());
				outCursor.get().add(in2Cursor.next());
			}
		}

		@Override
		public void mutate1(final IterableInterval<T> arg,
			final IterableInterval<T> in)
		{
			final Cursor<T> in1Cursor = arg.cursor();
			final Cursor<T> in2Cursor = in.cursor();
			while (in1Cursor.hasNext()) {
				in1Cursor.next().add(in2Cursor.next());
			}
		}

		@Override
		public void mutate2(final IterableInterval<T> in,
			final IterableInterval<T> arg)
		{
			final T tmp = in.firstElement().createVariable();
			final Cursor<T> in1Cursor = in.cursor();
			final Cursor<T> in2Cursor = arg.cursor();
			while (in1Cursor.hasNext()) {
				tmp.set(in1Cursor.next());
				tmp.add(in2Cursor.next());
				in2Cursor.get().set(tmp);
			}
		}

		@Override
		public Add<T> getIndependentInstance() {
			return this;
		}
	}
	
	@Plugin(type = Ops.Math.Subtract.class, priority = Priority.HIGH)
	public static class Subtract<T extends NumericType<T>> extends
		AbstractBinaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Ops.Math.Subtract, Contingent
	{

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in1(), in1().firstElement()
					.createVariable());
		}

		// TODO: extend common abstract base class which implements Contingent
		// for dimensionality checking.

		@Override
		public boolean conforms() {
			if (!Intervals.equalDimensions(in1(), in2())) return false;
			if (!in1().iterationOrder().equals(in2().iterationOrder())) return false;
			if (out() == null) return true;
			return Intervals.equalDimensions(in1(), out()) && in1().iterationOrder()
				.equals(out().iterationOrder());
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
			final Cursor<T> in1Cursor = input1.cursor();
			final Cursor<T> in2Cursor = input2.cursor();
			final Cursor<T> outCursor = output.cursor();
			while (in1Cursor.hasNext()) {
				outCursor.next().set(in1Cursor.next());
				outCursor.get().sub(in2Cursor.next());
			}
		}

		@Override
		public void mutate1(final IterableInterval<T> arg,
			final IterableInterval<T> in)
		{
			final Cursor<T> in1Cursor = arg.cursor();
			final Cursor<T> in2Cursor = in.cursor();
			while (in1Cursor.hasNext()) {
				in1Cursor.next().sub(in2Cursor.next());
			}
		}

		@Override
		public void mutate2(final IterableInterval<T> in,
			final IterableInterval<T> arg)
		{
			final T tmp = in.firstElement().createVariable();
			final Cursor<T> in1Cursor = in.cursor();
			final Cursor<T> in2Cursor = arg.cursor();
			while (in1Cursor.hasNext()) {
				tmp.set(in1Cursor.next());
				tmp.sub(in2Cursor.next());
				in2Cursor.get().set(tmp);
			}
		}

		@Override
		public Subtract<T> getIndependentInstance() {
			return this;
		}
	}
	
	@Plugin(type = Ops.Math.Multiply.class, priority = Priority.HIGH)
	public static class Multiply<T extends NumericType<T>> extends
		AbstractBinaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Ops.Math.Multiply, Contingent
	{

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in1(), in1().firstElement()
					.createVariable());
		}

		// TODO: extend common abstract base class which implements Contingent
		// for dimensionality checking.

		@Override
		public boolean conforms() {
			if (!Intervals.equalDimensions(in1(), in2())) return false;
			if (!in1().iterationOrder().equals(in2().iterationOrder())) return false;
			if (out() == null) return true;
			return Intervals.equalDimensions(in1(), out()) && in1().iterationOrder()
				.equals(out().iterationOrder());
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
			final Cursor<T> in1Cursor = input1.cursor();
			final Cursor<T> in2Cursor = input2.cursor();
			final Cursor<T> outCursor = output.cursor();
			while (in1Cursor.hasNext()) {
				outCursor.next().set(in1Cursor.next());
				outCursor.get().mul(in2Cursor.next());
			}
		}

		@Override
		public void mutate1(final IterableInterval<T> arg,
			final IterableInterval<T> in)
		{
			final Cursor<T> in1Cursor = arg.cursor();
			final Cursor<T> in2Cursor = in.cursor();
			while (in1Cursor.hasNext()) {
				in1Cursor.next().mul(in2Cursor.next());
			}
		}

		@Override
		public void mutate2(final IterableInterval<T> in,
			final IterableInterval<T> arg)
		{
			final T tmp = in.firstElement().createVariable();
			final Cursor<T> in1Cursor = in.cursor();
			final Cursor<T> in2Cursor = arg.cursor();
			while (in1Cursor.hasNext()) {
				tmp.set(in1Cursor.next());
				tmp.mul(in2Cursor.next());
				in2Cursor.get().set(tmp);
			}
		}

		@Override
		public Multiply<T> getIndependentInstance() {
			return this;
		}
	}
	
	@Plugin(type = Ops.Math.Divide.class, priority = Priority.HIGH)
	public static class Divide<T extends NumericType<T>> extends
		AbstractBinaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Ops.Math.Divide, Contingent
	{

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in1(), in1().firstElement()
					.createVariable());
		}

		// TODO: extend common abstract base class which implements Contingent
		// for dimensionality checking.

		@Override
		public boolean conforms() {
			if (!Intervals.equalDimensions(in1(), in2())) return false;
			if (!in1().iterationOrder().equals(in2().iterationOrder())) return false;
			if (out() == null) return true;
			return Intervals.equalDimensions(in1(), out()) && in1().iterationOrder()
				.equals(out().iterationOrder());
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
			final Cursor<T> in1Cursor = input1.cursor();
			final Cursor<T> in2Cursor = input2.cursor();
			final Cursor<T> outCursor = output.cursor();
			while (in1Cursor.hasNext()) {
				outCursor.next().set(in1Cursor.next());
				outCursor.get().div(in2Cursor.next());
			}
		}

		@Override
		public void mutate1(final IterableInterval<T> arg,
			final IterableInterval<T> in)
		{
			final Cursor<T> in1Cursor = arg.cursor();
			final Cursor<T> in2Cursor = in.cursor();
			while (in1Cursor.hasNext()) {
				in1Cursor.next().div(in2Cursor.next());
			}
		}

		@Override
		public void mutate2(final IterableInterval<T> in,
			final IterableInterval<T> arg)
		{
			final T tmp = in.firstElement().createVariable();
			final Cursor<T> in1Cursor = in.cursor();
			final Cursor<T> in2Cursor = arg.cursor();
			while (in1Cursor.hasNext()) {
				tmp.set(in1Cursor.next());
				tmp.div(in2Cursor.next());
				in2Cursor.get().set(tmp);
			}
		}

		@Override
		public Divide<T> getIndependentInstance() {
			return this;
		}
	}
}
