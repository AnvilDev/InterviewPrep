def is_valid(string):
    """
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid. (By determining that they close in the
    correct order.)

    :type s: str
    :rtype: bool
    """
    stack = []
    braces = {
        ')': '(',
        '}': '{',
        ']': '['
    }

    for brace in string:
        if brace in braces.values():
            stack.append(brace)
        elif brace in braces.keys():
            if stack == [] or braces[brace] != stack.pop():
                return False
    return stack == []
