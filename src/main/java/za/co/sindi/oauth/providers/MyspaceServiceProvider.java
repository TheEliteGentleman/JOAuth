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
package za.co.sindi.oauth.providers;

import net.oauth.provider.OAuth1ServiceProvider;

/**
 * @author Buhake Sindi
 * @since 29 June 2011
 *
 */
public class MyspaceServiceProvider extends OAuth1ServiceProvider {

	private static final String MYSPACE_OAUTH_URL_PATH = "http://api.myspace.com/";
	
	/**
	 * 
	 */
	public MyspaceServiceProvider() {
		super(MYSPACE_OAUTH_URL_PATH + "request_token", MYSPACE_OAUTH_URL_PATH + "authorize", MYSPACE_OAUTH_URL_PATH + "access_token");
		// TODO Auto-generated constructor stub
	}
}
