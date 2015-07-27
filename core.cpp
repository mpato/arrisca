#include "core.h"

Map::Map(int width, int height)
{
  this->width = width;
  this->height = height;
  this->cells = (Cell *) calloc(width * height, sizeof(Cell));
}

Cell * Map::get(int x, int y)
{
  if (x < 0 || x >= width)
    return NULL;
  if (y < 0 || y >= height)
    return NULL;
  return cells + width * y + x;
}

void Map::set(int x, int y, Cell scell)
{
  Cells * cell;
  cell = get(x, y);
  if (cell == null)
    return;
  *cell = scell;
}