/*
 * Copyright (c) 2002-2008 Gargoyle Software Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. The end-user documentation included with the redistribution, if any, must
 *    include the following acknowledgment:
 *
 *       "This product includes software developed by Gargoyle Software Inc.
 *        (http://www.GargoyleSoftware.com/)."
 *
 *    Alternately, this acknowledgment may appear in the software itself, if
 *    and wherever such third-party acknowledgments normally appear.
 * 4. The name "Gargoyle Software" must not be used to endorse or promote
 *    products derived from this software without prior written permission.
 *    For written permission, please contact info@GargoyleSoftware.com.
 * 5. Products derived from this software may not be called "HtmlUnit", nor may
 *    "HtmlUnit" appear in their name, without prior written permission of
 *    Gargoyle Software Inc.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GARGOYLE
 * SOFTWARE INC. OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gargoylesoftware.htmlunit.javascript.host;

import com.gargoylesoftware.htmlunit.html.BaseFrame;

/**
 * A JavaScript object for {@link com.gargoylesoftware.htmlunit.html.HtmlInlineFrame}.
 *
 * @version $Revision$
 * @author Marc Guillemot
 * @author Chris Erskine
 * @author Ahmed Ashour
 */
public class HTMLIFrameElement extends HTMLElement {

    private static final long serialVersionUID = -7005081332114203694L;

    /**
     * Create an instance.  A default constructor is required for all JavaScript objects.
     */
    public HTMLIFrameElement() { }

    /**
     * Return the value of URL loaded in the frame
     * @return The value of this attribute.
     */
    public String jsxGet_src() {
        return getFrame().getSrcAttribute();
    }

    /**
     * Returns the document the frame contains, if any
     * @return <code>null</code> if no document is contained
     * @see <a href="http://www.mozilla.org/docs/dom/domref/dom_frame_ref4.html">
     * Gecko DOM Reference</a>
     */
    public Document jsxGet_contentDocument() {
        return ((Window) getFrame().getEnclosedWindow().getScriptObject()).jsxGet_document();
    }

    /**
     * Returns the window the frame contains, if any
     * @return the window
     * @see <a href="http://www.mozilla.org/docs/dom/domref/dom_frame_ref5.html">
     * Gecko DOM Reference</a>
     * @see <a href="http://msdn.microsoft.com/workshop/author/dhtml/reference/properties/contentwindow.asp">
     * MSDN documentation</a>
     */
    public Window jsxGet_contentWindow() {
        return (Window) getFrame().getEnclosedWindow().getScriptObject();
    }

    /**
     * Set the value of the source of the contained frame.
     * @param src The new value.
     */
    public void jsxSet_src(final String src) {
        getFrame().setSrcAttribute(src);
    }

    /**
     * Return the value of the name attribute
     * @return The value of this attribute.
     */
    public String jsxGet_name() {
        return getFrame().getNameAttribute();
    }

    /**
     * Set the value of the name attribute.
     * @param name The new value.
     */
    public void jsxSet_name(final String name) {
        getFrame().setNameAttribute(name);
    }

    private BaseFrame getFrame() {
        return (BaseFrame) getHtmlElementOrDie();
    }

    /**
     * Set the onload event handler for this element.
     * @param eventHandler the new handler
     */
    public void jsxSet_onload(final Object eventHandler) {
        setEventHandlerProp("onload", eventHandler);
    }

    /**
     * Get the onload event handler for this element.
     * @return <code>org.mozilla.javascript.Function</code>
     */
    public Object jsxGet_onload() {
        return getEventHandlerProp("onload");
    }
}
