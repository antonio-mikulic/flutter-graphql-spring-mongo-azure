import 'package:flutter/material.dart';

import '../../models/game.dart';
import 'game-detail.dart';

class GamesList extends StatelessWidget {
  final List<Game> games;
  const GamesList({Key? key, required this.games}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: games.length,
        itemBuilder: (BuildContext context, int index) {
          return Card(
              child: InkWell(
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => GameDetailWidget(games[index])),
              );
            },
            child: ListTile(
              leading: const Icon(Icons.games),
              title: Text(games[index].name),
              subtitle: Text(games[index].rating.toString()),
            ),
          ));
        });
  }
}
