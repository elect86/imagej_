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
package net.imagej.ops.map;

import net.imagej.ops.Contingent;
import net.imagej.ops.Ops;
import net.imagej.ops.Parallel;
import net.imagej.ops.thread.chunker.ChunkerOp;
import net.imagej.ops.thread.chunker.CursorBasedChunk;
import net.imglib2.IterableInterval;
import net.imglib2.RandomAccessibleInterval;

import org.scijava.Priority;
import org.scijava.plugin.Plugin;

/**
 * Auto generated {@link MapBinaryComputer}s.
 *
 * @author Leon Yang
 */
public class MapBinaryComputers {

	private MapBinaryComputers() {
		// NB: Prevent instantiation of utility class.
	}

	/**
	 * {@link MapBinaryComputer} from {@link IterableInterval} and
	 * {@link IterableInterval} to {@link IterableInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 7)
	public static class IIAndIIToII<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, IterableInterval<EI1>, IterableInterval<EI2>, IterableInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final IterableInterval<EI1> input1,
			final IterableInterval<EI2> input2, final IterableInterval<EO> output)
		{
			Maps.map(input1, input2, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryComputer} from {@link IterableInterval} and
	 * {@link IterableInterval} to {@link IterableInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 17)
	public static class IIAndIIToIIParallel<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, IterableInterval<EI1>, IterableInterval<EI2>, IterableInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final IterableInterval<EI1> input1,
			final IterableInterval<EI2> input2, final IterableInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input1, input2, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, input1.size());
		}
	}

	/**
	 * {@link MapBinaryComputer} from {@link IterableInterval} and
	 * {@link IterableInterval} to {@link RandomAccessibleInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 6)
	public static class IIAndIIToRAI<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, IterableInterval<EI1>, IterableInterval<EI2>, RandomAccessibleInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final IterableInterval<EI1> input1,
			final IterableInterval<EI2> input2, final RandomAccessibleInterval<EO> output)
		{
			Maps.map(input1, input2, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryComputer} from {@link IterableInterval} and
	 * {@link IterableInterval} to {@link RandomAccessibleInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 16)
	public static class IIAndIIToRAIParallel<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, IterableInterval<EI1>, IterableInterval<EI2>, RandomAccessibleInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final IterableInterval<EI1> input1,
			final IterableInterval<EI2> input2, final RandomAccessibleInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input1, input2, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, input1.size());
		}
	}

	/**
	 * {@link MapBinaryComputer} from {@link IterableInterval} and
	 * {@link RandomAccessibleInterval} to {@link IterableInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 5)
	public static class IIAndRAIToII<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, IterableInterval<EI1>, RandomAccessibleInterval<EI2>, IterableInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final IterableInterval<EI1> input1,
			final RandomAccessibleInterval<EI2> input2, final IterableInterval<EO> output)
		{
			Maps.map(input1, input2, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryComputer} from {@link IterableInterval} and
	 * {@link RandomAccessibleInterval} to {@link IterableInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 15)
	public static class IIAndRAIToIIParallel<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, IterableInterval<EI1>, RandomAccessibleInterval<EI2>, IterableInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final IterableInterval<EI1> input1,
			final RandomAccessibleInterval<EI2> input2, final IterableInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input1, input2, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, input1.size());
		}
	}

	/**
	 * {@link MapBinaryComputer} from {@link IterableInterval} and
	 * {@link RandomAccessibleInterval} to {@link RandomAccessibleInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 4)
	public static class IIAndRAIToRAI<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, IterableInterval<EI1>, RandomAccessibleInterval<EI2>, RandomAccessibleInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final IterableInterval<EI1> input1,
			final RandomAccessibleInterval<EI2> input2, final RandomAccessibleInterval<EO> output)
		{
			Maps.map(input1, input2, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryComputer} from {@link IterableInterval} and
	 * {@link RandomAccessibleInterval} to {@link RandomAccessibleInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 14)
	public static class IIAndRAIToRAIParallel<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, IterableInterval<EI1>, RandomAccessibleInterval<EI2>, RandomAccessibleInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final IterableInterval<EI1> input1,
			final RandomAccessibleInterval<EI2> input2, final RandomAccessibleInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input1, input2, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, input1.size());
		}
	}

	/**
	 * {@link MapBinaryComputer} from {@link RandomAccessibleInterval} and
	 * {@link IterableInterval} to {@link IterableInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 3)
	public static class RAIAndIIToII<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, RandomAccessibleInterval<EI1>, IterableInterval<EI2>, IterableInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final RandomAccessibleInterval<EI1> input1,
			final IterableInterval<EI2> input2, final IterableInterval<EO> output)
		{
			Maps.map(input1, input2, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryComputer} from {@link RandomAccessibleInterval} and
	 * {@link IterableInterval} to {@link IterableInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 13)
	public static class RAIAndIIToIIParallel<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, RandomAccessibleInterval<EI1>, IterableInterval<EI2>, IterableInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final RandomAccessibleInterval<EI1> input1,
			final IterableInterval<EI2> input2, final IterableInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input1, input2, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, input2.size());
		}
	}

	/**
	 * {@link MapBinaryComputer} from {@link RandomAccessibleInterval} and
	 * {@link IterableInterval} to {@link RandomAccessibleInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 2)
	public static class RAIAndIIToRAI<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, RandomAccessibleInterval<EI1>, IterableInterval<EI2>, RandomAccessibleInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final RandomAccessibleInterval<EI1> input1,
			final IterableInterval<EI2> input2, final RandomAccessibleInterval<EO> output)
		{
			Maps.map(input1, input2, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryComputer} from {@link RandomAccessibleInterval} and
	 * {@link IterableInterval} to {@link RandomAccessibleInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 12)
	public static class RAIAndIIToRAIParallel<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, RandomAccessibleInterval<EI1>, IterableInterval<EI2>, RandomAccessibleInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final RandomAccessibleInterval<EI1> input1,
			final IterableInterval<EI2> input2, final RandomAccessibleInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input1, input2, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, input2.size());
		}
	}

	/**
	 * {@link MapBinaryComputer} from {@link RandomAccessibleInterval} and
	 * {@link RandomAccessibleInterval} to {@link IterableInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 1)
	public static class RAIAndRAIToII<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, RandomAccessibleInterval<EI1>, RandomAccessibleInterval<EI2>, IterableInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final RandomAccessibleInterval<EI1> input1,
			final RandomAccessibleInterval<EI2> input2, final IterableInterval<EO> output)
		{
			Maps.map(input1, input2, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryComputer} from {@link RandomAccessibleInterval} and
	 * {@link RandomAccessibleInterval} to {@link IterableInterval}.
	 * 
	 * @param <EI1> element type of first inputs
	 * @param <EI2> element type of second inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 11)
	public static class RAIAndRAIToIIParallel<EI1, EI2, EO> extends
		AbstractMapBinaryComputer<EI1, EI2, EO, RandomAccessibleInterval<EI1>, RandomAccessibleInterval<EI2>, IterableInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2(), out());
		}

		@Override
		public void compute(final RandomAccessibleInterval<EI1> input1,
			final RandomAccessibleInterval<EI2> input2, final IterableInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input1, input2, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, output.size());
		}
	}

}
