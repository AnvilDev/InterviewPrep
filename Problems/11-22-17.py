def reduce_tree(node, minumum, maximum):
    """This method removes nodes of a tree outside a given range [minumum, maximum]."""
    if node is None:
        return None
    else:
        if node.data < minumum:
            if node.right is not None:
                node = reduce_tree(node.right, minumum, maximum)
            else:
                return None
        elif node.data > maximum:
            if node.left is not None:
                node = reduce_tree(node.left, minumum, maximum)
            else:
                return None
        else:
            if node.right is not None:
                node.right = reduce_tree(node.right, minumum, maximum)
            if node.left is not None:
                node.left = reduce_tree(node.left, minumum, maximum)
        return node

class Node(object):
    """This class defines a node in a tree."""
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right
