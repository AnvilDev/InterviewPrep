def swap_nums(x, y):
    """Swap a number in place (without a temporary variable)"""
    x = x + y
    y = x - y
    x = x - y
    return (x, y)
