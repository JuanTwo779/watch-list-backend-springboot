package com.juan.rest.watchlist.restapiwatchlist.tmdbAPI;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TmdbApiService {

    private final OkHttpClient client;
    private static final String TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YTg3MjUyMTc1MTdmM2ZjNTE4NGQ1NzhiOTZlMjVlYyIsInN1YiI6IjY0OGM0ZTI4MDc2Y2U4MDE0NDI1NzdhNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7rDmZS7BMcXmib8FRlL-1_krO4KG0GAgyHnqxOTHk9E";

    public TmdbApiService() {
        this.client = new OkHttpClient();
    }

    public String searchMovies(String query, String language, String primaryReleaseYear, Integer page, String region, String year) throws IOException {

        String url = "https://api.themoviedb.org/3/search/movie";

        if (query != null){
            url = url + "?query=" + query;
        } else if (language != null) {
            url = url + "&language=" + language;
        } else if (primaryReleaseYear != null) {
            url = url + "&primary_release_year=" + primaryReleaseYear;
        } else if (page != null) {
            url = url + "&page=" + page;
        } else if (region != null) {
            url = url + "&region=" + region;
        } else if (year != null) {
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
}
