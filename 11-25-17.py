def brute_force_median(nums1, nums2):
    """
    This implements a brute force solution to find
    the median of two sorted lists.

    The ideal solution is O(log(m + n)), I haven't gotten
    there quite yet.

    :type nums1: List[int]
    :type nums2: List[int]
    :rtype: float
    """
    nums = sorted(nums1 + nums2)
    length = len(nums)

    if length & 1:
        return nums[(length // 2)]
    else:
        return (nums[length // 2] + nums[(length // 2) - 1]) / 2
