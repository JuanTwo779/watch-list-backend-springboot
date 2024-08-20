package com.juan.rest.watchlist.restapiwatchlist.tmdbAPI;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TmdbApiService {

    private final OkHttpClient client;
    private final String baseUrl = "https://api.themoviedb.org/3/";
    private static final String TOKEN = System.getenv("TmdbToken");
    public TmdbApiService() {
        this.client = new OkHttpClient();
    }

    public String searchMovies(String query, String language, String primaryReleaseYear, Integer page, String region, String year) throws IOException {

        String url = baseUrl + "search/movie";

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
                assert response.body() != null;
                return response.body().string();
            } else {
                throw new IOException("HTTP error " + response.code() + " - " + response.message());
            }
        }

    }

    //get movie credits
    public String getMovieCredits(int movieId) throws IOException {

        String url = baseUrl + "/movie/" + movieId + "/credits?language=en-US";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", TOKEN)
                .build();

//        Request request = new Request.Builder()
//                .url("https://api.themoviedb.org/3/movie/2/credits?language=en-US")
//                .get()
//                .addHeader("accept", "application/json")
//                .addHeader("Authorization", "")
//                .build();

        try(Response response = client.newCall(request).execute()){
            if (response.isSuccessful()){
                assert response.body() != null;
                return response.body().string();
            } else {
                throw new IOException("HTTP error " + response.code() + " - " + response.message());
            }
        }

    }
}
