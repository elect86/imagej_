/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2021 ImageJ developers.
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

package net.imagej.space;

import java.util.List;

import net.imagej.axis.Axes;
import net.imagej.axis.CalibratedAxis;
import net.imagej.axis.IdentityAxis;

/**
 * Default implementation of {@link CalibratedSpace}.
 * 
 * @author Curtis Rueden
 */
public final class DefaultCalibratedSpace extends
	AbstractCalibratedSpace<CalibratedAxis>
{

	/**
	 * Constructs a new calibrated space of the given dimensionality, with default
	 * {@link IdentityAxis} axes of unknown type ({@link Axes#unknown()}).
	 */
	public DefaultCalibratedSpace(final int numDims) {
		super(numDims);
		for (int d = 0; d < numDims; d++) {
			setAxis(new IdentityAxis(), d);
		}
	}

	/** Constructs a new calibrated space with the given axes. */
	public DefaultCalibratedSpace(final CalibratedAxis... axes) {
		super(axes);
	}

	/** Constructs a new calibrated space with the given axes. */
	public DefaultCalibratedSpace(final List<CalibratedAxis> axes) {
		super(axes);
	}

}
