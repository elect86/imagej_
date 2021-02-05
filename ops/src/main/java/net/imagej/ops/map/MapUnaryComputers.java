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

import org.scijava.plugin.Plugin;

/**
 * Auto generated {@link MapUnaryComputer}s.
 *
 * @author Leon Yang
 * @author Christian Dietz (University of Konstanz)
 * @author Curtis Rueden
 */
public class MapUnaryComputers {

	private MapUnaryComputers() {
		// NB: Prevent instantiation of utility class.
	}

	/**
	 * {@link MapUnaryComputer} from {@link IterableInterval} to
	 * {@link IterableInterval}.
	 * 
	 * @param <EI> element type of inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = 3)
	public static class IIToII<EI, EO> extends
		AbstractMapComputer<EI, EO, IterableInterval<EI>, IterableInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in(), out());
		}

		@Override
		public void compute(final IterableInterval<EI> input,
			final IterableInterval<EO> output)
		{
			Maps.map(input, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapUnaryComputer} from {@link IterableInterval} to
	 * {@link IterableInterval}.
	 * 
	 * @param <EI> element type of inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = 13)
	public static class IIToIIParallel<EI, EO> extends
		AbstractMapComputer<EI, EO, IterableInterval<EI>, IterableInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in(), out());
		}

		@Override
		public void compute(final IterableInterval<EI> input,
			final IterableInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, input.size());
		}
	}

	/**
	 * {@link MapUnaryComputer} from {@link IterableInterval} to
	 * {@link RandomAccessibleInterval}.
	 * 
	 * @param <EI> element type of inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = 2)
	public static class IIToRAI<EI, EO> extends
		AbstractMapComputer<EI, EO, IterableInterval<EI>, RandomAccessibleInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in(), out());
		}

		@Override
		public void compute(final IterableInterval<EI> input,
			final RandomAccessibleInterval<EO> output)
		{
			Maps.map(input, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapUnaryComputer} from {@link IterableInterval} to
	 * {@link RandomAccessibleInterval}.
	 * 
	 * @param <EI> element type of inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = 12)
	public static class IIToRAIParallel<EI, EO> extends
		AbstractMapComputer<EI, EO, IterableInterval<EI>, RandomAccessibleInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in(), out());
		}

		@Override
		public void compute(final IterableInterval<EI> input,
			final RandomAccessibleInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, input.size());
		}
	}

	/**
	 * {@link MapUnaryComputer} from {@link RandomAccessibleInterval} to
	 * {@link IterableInterval}.
	 * 
	 * @param <EI> element type of inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = 1)
	public static class RAIToII<EI, EO> extends
		AbstractMapComputer<EI, EO, RandomAccessibleInterval<EI>, IterableInterval<EO>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in(), out());
		}

		@Override
		public void compute(final RandomAccessibleInterval<EI> input,
			final IterableInterval<EO> output)
		{
			Maps.map(input, output, getOp());
		}
	}

	/**
	 * Parallelized {@link MapUnaryComputer} from {@link RandomAccessibleInterval} to
	 * {@link IterableInterval}.
	 * 
	 * @param <EI> element type of inputs
	 * @param <EO> element type of outputs
	 */
	@Plugin(type = Ops.Map.class, priority = 11)
	public static class RAIToIIParallel<EI, EO> extends
		AbstractMapComputer<EI, EO, RandomAccessibleInterval<EI>, IterableInterval<EO>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in(), out());
		}

		@Override
		public void compute(final RandomAccessibleInterval<EI> input,
			final IterableInterval<EO> output)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.map(input, output, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, output.size());
		}
	}

}
