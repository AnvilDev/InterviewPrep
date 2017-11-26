def two_sum(nums, target):
    """
    O(n) solution to find the indeces of two numbers in a list
    that add up to a certain target

    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    differences = {}

    for i in range(len(nums)):
        if nums[i] in differences:
            return [differences[nums[i]], i]
        else:
            differences[target - nums[i]] = i
