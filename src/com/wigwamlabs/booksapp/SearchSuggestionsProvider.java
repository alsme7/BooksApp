/*
 * Copyright 2011 Jonas Bengtsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wigwamlabs.booksapp;

import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.provider.SearchRecentSuggestions;

public class SearchSuggestionsProvider extends SearchRecentSuggestionsProvider {
	private static final String AUTHORITY = "com.wigwamlabs.booksapp.SearchSuggestionsProvider";
	private static final int MODE = DATABASE_MODE_QUERIES;

	static void saveQuery(final Context context, final String query) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				final SearchRecentSuggestions suggestions = new SearchRecentSuggestions(context,
						AUTHORITY, MODE);
				suggestions.saveRecentQuery(query, null);
			}
		}).start();
	}

	public SearchSuggestionsProvider() {
		setupSuggestions(AUTHORITY, MODE);
	}
}
