import 'dart:convert';
import 'dart:io';

import 'package:frontend/models/game.dart';
import 'package:http/http.dart';

class GameService {
  var headers = {
    HttpHeaders.contentTypeHeader: "application/json",
  };

  Future<List<Game>> getGames() async {
    Uri uri = Uri.http("localhost:8080", "/v1/games");
    Response res = await get(uri, headers: headers);

    if (res.statusCode == 200) {
      List<dynamic> body = jsonDecode(res.body);
      List<Game> game = body.map((dynamic item) => Game.fromJson(item)).toList();
      return game;
    } else {
      throw "Failed to load Game list";
    }
  }

  Future<Game> getGameById(String id) async {
    final response = await get(Uri.http("localhost:8080", "/v1/games/$id"));

    if (response.statusCode == 200) {
      return Game.fromJson(json.decode(response.body));
    } else {
      throw Exception('Failed to load a Game');
    }
  }

  Future<Game> createGame(Game game) async {
    Map data = {
      'name': game.name,
      'description': game.description,
      'rating': game.rating,
    };

    final Response response = await post(
      Uri.http("localhost:8080", "/v1/games"),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(data),
    );
    if (response.statusCode == 200) {
      return Game.fromJson(json.decode(response.body));
    } else {
      throw Exception('Failed to post Game');
    }
  }

  Future<Game> updateGame(String id, Game game) async {
    Map data = {
      'name': game.name,
      'description': game.description,
      'rating': game.rating,
    };

    final Response response = await put(Uri.http("localhost:8080", "/v1/games/$id"),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
        },
        body: jsonEncode(data));
    if (response.statusCode == 200) {
      return Game.fromJson(json.decode(response.body));
    } else {
      throw Exception('Failed to update a ');
    }
  }

  Future<void> deleteGame(String id) async {
    Response res = await delete(Uri.http("localhost:8080", "/v1/games/$id"));

    if (res.statusCode == 200) {
      print("Game deleted");
    } else {
      throw "Failed to delete a Game.";
    }
  }
}
