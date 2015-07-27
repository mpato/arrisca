struct Point
{
  int x, y;
};

struct Route
{
  Point points[10];
  int points;
  int refs;
};

struct Cell
{
  int owner_id;
};

class Map {
private:
  Cell * cells;
  int width, height;
public:
  Map(int width, int height);
  Cell *get(int x, int y);
  void set(int x, int y, Cell cell);
};