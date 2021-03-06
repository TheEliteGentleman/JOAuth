/**
 *  Copyright 2010-2011 Buhake Sindi

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package net.oauth.browser;

import java.io.IOException;
import java.net.URL;

/**
 * @author Buhake Sindi
 * @since 14 July 2011
 *
 */
public abstract class AbstractBrowser implements Browser {

	/* (non-Javadoc)
	 * @see net.oauth.browser.Browser#browse(java.net.URL)
	 */
	@Override
	public final void browse(URL url) throws IOException {
		// TODO Auto-generated method stub
		if (url == null) {
			throw new IOException("No URL provided.");
		}
		
		browse(url.toString());
	}
}
