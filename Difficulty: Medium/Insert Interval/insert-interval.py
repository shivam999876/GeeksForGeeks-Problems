#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

import bisect

class Solution:

    def insertInterval(self, intervals, newInterval):

        # Code here

        l = [intervals[i][1] for i in range(len(intervals))]

        ind = bisect.bisect_right(l, newInterval[0])

        

        intervals.insert(ind, newInterval)

        #print(intervals)

        intervals.sort()

        

        st = [intervals[0]]

        for i in intervals[1:]:

            if st[-1][1] >= i[0]:

                st[-1][1] = max(st[-1][1], i[1])

            else:

                st.append(i)

        return st

#{ 
 # Driver Code Starts.
if __name__ == '__main__': 
    t = int(input ())
    for _ in range (t):
        N = int(input())
        intervals = [list(map(int, input().split())) for i in range(N)]
        newEvent = list(map(int, input().split()))
        ob = Solution()
        res = ob.insertInterval(intervals, newEvent)
        print('[', end = '')
        for i in range(len(res)):
            print('[', end = '')
            print(str(res[i][0])+','+str(res[i][1]), end = '')
            print(']', end = '')
            if i < len(res)-1:
                print(',', end='')
        print(']')
        print("~")
# } Driver Code Ends