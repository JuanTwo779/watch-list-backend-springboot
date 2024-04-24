package com.juan.rest.watchlist.restapiwatchlist.tmdbAPI;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TmdbApiService {

    private final OkHttpClient client;
    private String baseUrl = "https://api.themoviedb.org/3/search/movie";
    private static final String TOKEN = "";
    public TmdbApiService() {
        this.client = new OkHttpClient();
    }

    public String searchMovies(String query, String language, String primaryReleaseYear, Integer page, String region, String year) throws IOException {

        String url = baseUrl;

        if (query != null){
            url = url + "?query=" + query;
        }
        if (language != null) {
            url = url + "&language=" + language;
        }
        if (primaryReleaseYear != null) {
            url = url + "&primary_release_year=" + primaryReleaseYear;
        }
        if (page != null) {
            url = url + "&page=" + page;
        }
        if (region != null) {
            url = url + "&region=" + region;
        }
        if (year != null) {
            url = url + "&year=" + year;
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", TOKEN)
                .build();

        try(Response response = client.newCall(request).execute()){
            if (response.isSuccessful()){
                return response.body().string();
            } else {
                throw new IOException("HTTP error " + response.code() + " - " + response.message());
            }
        }

    }

    public void setBaseUrl(String url) {
        this.baseUrl = url;
    }
}
