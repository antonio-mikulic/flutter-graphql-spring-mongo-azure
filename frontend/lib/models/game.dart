class Game {
  final String id;
  final double rating;
  final String name;
  final String description;

  const Game({
    required this.name,
    required this.id,
    required this.description,
    required this.rating,
  });

  factory Game.fromJson(Map<String, dynamic> json) {
    return Game(
      name: json['_name'],
      id: json['_id'],
      description: json['_description'],
      rating: json['_rating'],
    );
  }
}
