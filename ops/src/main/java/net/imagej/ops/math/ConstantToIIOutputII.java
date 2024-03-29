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
import net.imagej.ops.special.hybrid.AbstractUnaryHybridCFI;
import net.imglib2.Cursor;
import net.imglib2.IterableInterval;
import net.imglib2.type.numeric.NumericType;

import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

/**
 * Wrapper class for functional binary math operations between constant values 
 * and {@link IterableInterval}s, and write the result
 * to {@link IterableInterval}s.
 *
 * @author Leon Yang
 */
public final class ConstantToIIOutputII {
	
	private ConstantToIIOutputII() {
		// NB: Prevent instantiation of utility class.
	}

	@Plugin(type = Ops.Math.Add.class)
	public static class Add<T extends NumericType<T>> extends
		AbstractUnaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Contingent, Ops.Math.Add
	{

		@Parameter
		private T value;

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in(), in().firstElement()
					.createVariable());
		}

		@Override
		public void compute(final IterableInterval<T> input,
			final IterableInterval<T> output)
		{
			final Cursor<T> inCursor = input.cursor();
			final Cursor<T> outCursor = output.cursor();
			while (inCursor.hasNext()) {
				outCursor.next().set(inCursor.next());
				outCursor.get().add(value);
			}
		}

		@Override
		public IterableInterval<T> createOutput(final IterableInterval<T> input) {
			return outputCreator.calculate(input);
		}

		@Override
		public boolean conforms() {
			if (out() == null) return true;
			return in().iterationOrder().equals(out().iterationOrder());
		}

		@Override
		public void mutate(final IterableInterval<T> arg) {
			for (final T t : arg) {
				t.add(value);
			}
		}

		@Override
		public Add<T> getIndependentInstance() {
			return this;
		}
	}

	@Plugin(type = Ops.Math.Subtract.class)
	public static class Subtract<T extends NumericType<T>> extends
		AbstractUnaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Contingent, Ops.Math.Subtract
	{

		@Parameter
		private T value;

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in(), in().firstElement()
					.createVariable());
		}

		@Override
		public void compute(final IterableInterval<T> input,
			final IterableInterval<T> output)
		{
			final Cursor<T> inCursor = input.cursor();
			final Cursor<T> outCursor = output.cursor();
			while (inCursor.hasNext()) {
				outCursor.next().set(inCursor.next());
				outCursor.get().sub(value);
			}
		}

		@Override
		public IterableInterval<T> createOutput(final IterableInterval<T> input) {
			return outputCreator.calculate(input);
		}

		@Override
		public boolean conforms() {
			if (out() == null) return true;
			return in().iterationOrder().equals(out().iterationOrder());
		}

		@Override
		public void mutate(final IterableInterval<T> arg) {
			for (final T t : arg) {
				t.sub(value);
			}
		}

		@Override
		public Subtract<T> getIndependentInstance() {
			return this;
		}
	}

	@Plugin(type = Ops.Math.Multiply.class)
	public static class Multiply<T extends NumericType<T>> extends
		AbstractUnaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Contingent, Ops.Math.Multiply
	{

		@Parameter
		private T value;

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in(), in().firstElement()
					.createVariable());
		}

		@Override
		public void compute(final IterableInterval<T> input,
			final IterableInterval<T> output)
		{
			final Cursor<T> inCursor = input.cursor();
			final Cursor<T> outCursor = output.cursor();
			while (inCursor.hasNext()) {
				outCursor.next().set(inCursor.next());
				outCursor.get().mul(value);
			}
		}

		@Override
		public IterableInterval<T> createOutput(final IterableInterval<T> input) {
			return outputCreator.calculate(input);
		}

		@Override
		public boolean conforms() {
			if (out() == null) return true;
			return in().iterationOrder().equals(out().iterationOrder());
		}

		@Override
		public void mutate(final IterableInterval<T> arg) {
			for (final T t : arg) {
				t.mul(value);
			}
		}

		@Override
		public Multiply<T> getIndependentInstance() {
			return this;
		}
	}

	@Plugin(type = Ops.Math.Divide.class)
	public static class Divide<T extends NumericType<T>> extends
		AbstractUnaryHybridCFI<IterableInterval<T>, IterableInterval<T>>
		implements Contingent, Ops.Math.Divide
	{

		@Parameter
		private T value;

		private UnaryFunctionOp<IterableInterval<T>, IterableInterval<T>> outputCreator;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize() {
			outputCreator = (UnaryFunctionOp) Functions.unary(ops(),
				Ops.Create.Img.class, IterableInterval.class, in(), in().firstElement()
					.createVariable());
		}

		@Override
		public void compute(final IterableInterval<T> input,
			final IterableInterval<T> output)
		{
			final Cursor<T> inCursor = input.cursor();
			final Cursor<T> outCursor = output.cursor();
			while (inCursor.hasNext()) {
				outCursor.next().set(inCursor.next());
				outCursor.get().div(value);
			}
		}

		@Override
		public IterableInterval<T> createOutput(final IterableInterval<T> input) {
			return outputCreator.calculate(input);
		}

		@Override
		public boolean conforms() {
			if (out() == null) return true;
			return in().iterationOrder().equals(out().iterationOrder());
		}

		@Override
		public void mutate(final IterableInterval<T> arg) {
			for (final T t : arg) {
				t.div(value);
			}
		}

		@Override
		public Divide<T> getIndependentInstance() {
			return this;
		}
	}
}
