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

BinarySearchTree* BinarySearchTree::insert_node(BinarySearchTree *node, int key, void *e)
{
  if (node == null) {
    node = new BinarySearchTree();
    node->key = key;
    node->e = e;
    return node;
  }
  if (key == node->key)
    node->e = e;
  else if (key < node->key)
    node->left = insert_node(this->left, key, e);
  else
    node->right = insert_node(this->right, key, e);
}

void BinarySearchTree::insert(int key, void *e)
{
  insert_node(this, key, e);
}

void* BinarySearchTree::get_node(BinarySearchTree *node, int key)
{
  if (node == null)
    return NULL;
  if (key == node->key)
    return node->e;
  else if (key <= node->key)
    return get_node(this->left, key);
  else
    return get_node(this->right, key);
}

void* BinarySearchTree::insert(int key, void *e)
{
  return get_node(this, key, e);
}
