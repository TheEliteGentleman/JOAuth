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
package net.oauth.token.oauth1;

import net.oauth.util.OAuth1Util;

/**
 * @author Bienfait Sindi
 * @since 20 November 2010
 *
 */
public class RequestToken extends TokenSecretBasedToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5435052772260977531L;
	private boolean oauthCallbackConfirmed;
	
	/**
	 * 
	 * @param token
	 * @param tokenSecret
	 * @param oauthCallbackConfirmed
	 */
	public RequestToken(String token, String tokenSecret, boolean oauthCallbackConfirmed) {
		super(token, tokenSecret);
		// TODO Auto-generated constructor stub
		this.oauthCallbackConfirmed = oauthCallbackConfirmed;
	}

	/**
	 * @return the oauthCallbackConfirmed
	 */
	public boolean isOauthCallbackConfirmed() {
		return oauthCallbackConfirmed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("oauth_token=" + OAuth1Util.encode(getToken()) + "&oauth_token_secret=" + OAuth1Util.encode(getTokenSecret()) + "&oauth_callback_confirmed=" + Boolean.toString(isOauthCallbackConfirmed()));
	}
}
