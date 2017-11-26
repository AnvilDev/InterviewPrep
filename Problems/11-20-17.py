def swap_nums(x, y):
    """
    Swap a number in place (without a temporary variable)

    :type x: int
    :type y: int
    :rtype: tuple[int]
    """
    x = x + y
    y = x - y
    x = x - y
    return (x, y)

def swap_nums_2(x, y):
    """
    Learned some new Python stuff and figured I could update this.
    Swapping in place with Python tuples!

    :type x: int
    :type y: int
    :rtype: tuple[int]
    """
    (x, y) = (y, x)
    return (x, y)
