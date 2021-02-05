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
 * Auto generated {@link MapBinaryInplace1}s.
 *
 * @author Leon Yang
 */
public class MapBinaryInplace1s {

	private MapBinaryInplace1s() {
		// NB: Prevent instantiation of utility class.
	}

	/**
	 * {@link MapBinaryInplace1} of {@link IterableInterval} with additional input
	 * of {@link IterableInterval}.
	 * 
	 * @author Leon Yang
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 3)
	public static class IIAndII<EA, EI> extends
		AbstractMapBinaryInplace1<EA, EI, EA, IterableInterval<EA>, IterableInterval<EI>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2());
		}

		@Override
		public void mutate1(final IterableInterval<EA> arg,
			final IterableInterval<EI> in)
		{
			Maps.inplace(arg, in, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryInplace1} of {@link IterableInterval}
	 * with additional input of {@link IterableInterval}.
	 * 
	 * @author Leon Yang
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 13)
	public static class IIAndIIParallel<EA, EI> extends
		AbstractMapBinaryInplace1<EA, EI, EA, IterableInterval<EA>, IterableInterval<EI>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2());
		}

		@Override
		public void mutate1(final IterableInterval<EA> arg,
			final IterableInterval<EI> in)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.inplace(arg, in, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, arg.size());
		}
	}

	/**
	 * {@link MapBinaryInplace1} of {@link IterableInterval} with additional input
	 * of {@link RandomAccessibleInterval}.
	 * 
	 * @author Leon Yang
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 2)
	public static class IIAndRAI<EA, EI> extends
		AbstractMapBinaryInplace1<EA, EI, EA, IterableInterval<EA>, RandomAccessibleInterval<EI>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2());
		}

		@Override
		public void mutate1(final IterableInterval<EA> arg,
			final RandomAccessibleInterval<EI> in)
		{
			Maps.inplace(arg, in, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryInplace1} of {@link IterableInterval}
	 * with additional input of {@link RandomAccessibleInterval}.
	 * 
	 * @author Leon Yang
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 12)
	public static class IIAndRAIParallel<EA, EI> extends
		AbstractMapBinaryInplace1<EA, EI, EA, IterableInterval<EA>, RandomAccessibleInterval<EI>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2());
		}

		@Override
		public void mutate1(final IterableInterval<EA> arg,
			final RandomAccessibleInterval<EI> in)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.inplace(arg, in, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, arg.size());
		}
	}

	/**
	 * {@link MapBinaryInplace1} of {@link RandomAccessibleInterval} with additional input
	 * of {@link IterableInterval}.
	 * 
	 * @author Leon Yang
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 1)
	public static class RAIAndII<EA, EI> extends
		AbstractMapBinaryInplace1<EA, EI, EA, RandomAccessibleInterval<EA>, IterableInterval<EI>>
		implements Contingent
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2());
		}

		@Override
		public void mutate1(final RandomAccessibleInterval<EA> arg,
			final IterableInterval<EI> in)
		{
			Maps.inplace(arg, in, getOp());
		}
	}

	/**
	 * Parallelized {@link MapBinaryInplace1} of {@link RandomAccessibleInterval}
	 * with additional input of {@link IterableInterval}.
	 * 
	 * @author Leon Yang
	 */
	@Plugin(type = Ops.Map.class, priority = Priority.LOW + 11)
	public static class RAIAndIIParallel<EA, EI> extends
		AbstractMapBinaryInplace1<EA, EI, EA, RandomAccessibleInterval<EA>, IterableInterval<EI>>
		implements Contingent, Parallel
	{
		@Override
		public boolean conforms() {
			return out() == null || Maps.compatible(in1(), in2());
		}

		@Override
		public void mutate1(final RandomAccessibleInterval<EA> arg,
			final IterableInterval<EI> in)
		{
			ops().run(ChunkerOp.class, new CursorBasedChunk() {
				@Override
				public void execute(final long startIndex, final long stepSize,
					final long numSteps)
				{
					Maps.inplace(arg, in, getOp().getIndependentInstance(),
						startIndex, stepSize, numSteps);
				}
			}, in.size());
		}
	}

}
