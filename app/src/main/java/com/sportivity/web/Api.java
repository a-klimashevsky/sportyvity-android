package com.sportivity.web;

import com.sportivity.web.entities.AuthDataApi;
import com.sportivity.web.entities.Client;
import com.sportivity.web.entities.Exercise;
import com.sportivity.web.entities.Message;
import com.sportivity.web.entities.Program;
import com.sportivity.web.entities.Request;
import com.sportivity.web.entities.Result;
import com.sportivity.web.entities.Session;
import com.sportivity.web.entities.Trainer;
import com.sportivity.web.entities.Workout;
import com.sportivity.web.entities.WorkoutReport;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public interface Api {

    @POST("/sessions")
    Session login(@Body AuthDataApi dataApi);

    @POST("/clients")
    Client createClient(@Body Client client);

    @GET("/clients/{id}")
    Client getClient(@Path("id") String id);

    @PUT("/clients/{id}")
    Client updateClient(@Path("id") String id, @Body Client client);

    @GET("/clients/{id}/trainers")
    List<Trainer> getTrainers(@Path("id") String id);

    @GET("/clients/{id}/programs")
    List<Program> getClientPrograms(@Path("id") String id);

    @GET("clients/{clientId}/programs/{id}/workouts")
    List<Workout> getClientWorkouts(@Path("clientId")String clientId, @Path("id") String programId);

    @GET("clients/{clientId}/programs/{programId}/workouts/{id}/exercises")
    List<Exercise> getClientExercises(@Path("clientId")String clientId,
                                      @Path("programId") String programId,
                                      @Path("id") String workoutId);
    @GET("/clients/{id}/requests")
    List<Request> getClientRequests(@Path("id") String clientId);

    @POST("/clients/{id}/requests")
    Request createRequest(@Path("id")String clientId, @Body Request request);

    @DELETE("/clients/{clientId}/requests/{id}")
    Request deleteRequest(@Path("clientId") String clientId, @Path("id") String requestId);

    @GET("/clients/{id}/messages")
    List<Message> getClientMessages(@Path("id") String clientId);

    @POST("/messages")
    Message createMessage(@Body Message message);

    @POST("clients/{id}/workoutreports")
    WorkoutReport createWorkoutReport(@Path("id") String clientId);

    @POST("clients/{clientId}/workoutreports/{id}/results")
    Result createResult(@Path("clientId") String clientId,
                        @Path("id")String workoutReportId,
                        @Body Result result);

    @GET("trainers")
    List<Trainer> getTrainers(@Query("type") int type, @Query("minRating") float minRating);
}
