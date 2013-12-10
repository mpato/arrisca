#include "utils.h"

BinarySearchTree::BinarySearchTree()
{
  key = 0;
  left = NULL;
  right = NULL;
}

BinarySearchTree::~BinarySearchTree()
{
  if (left)
    delete left;
  if (right)
    delete right;
}


