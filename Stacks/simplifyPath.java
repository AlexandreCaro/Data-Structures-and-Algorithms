// Level: Medium. 71. Simplify path.

/*
 * Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.

In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.

The simplified canonical path should adhere to the following rules:

    It must start with a single slash '/'.
    Directories within the path should be separated by only one slash '/'.
    It should not end with a slash '/', unless it's the root directory.
    It should exclude any single or double periods used to denote current or parent directories.

Return the new path.

Example 1:

Input: path = "/home/"

Output: "/home"

Explanation:

The trailing slash should be removed.
 
Example 2:

Input: path = "/home//foo/"

Output: "/home/foo"

Explanation:

Multiple consecutive slashes are replaced by a single one.

Example 3:

Input: path = "/home/user/Documents/../Pictures"

Output: "/home/user/Pictures"

Explanation:

A double period ".." refers to the directory up a level.

Example 4:

Input: path = "/../"

Output: "/"

Explanation:

Going one level up from the root directory is not possible.

Example 5:

Input: path = "/.../a/../b/c/../d/./"

Output: "/.../b/d"

Explanation:

"..." is a valid name for a directory in this problem.


 */

class Solution {
    public String simplifyPath(String path) {

        String[] components = path.split("/");

        Stack<String> stack = new Stack<>();

        for(String component: components)
        {
            if(component.equals(".."))
            {
                if(!stack.empty()) stack.pop();
            }

            else if(!component.isEmpty() && !component.equals(".")) stack.push(component);
        }

        StringBuilder result = new StringBuilder();

        if(stack.empty()) result.append('/');

        for(String dir: stack)
        {
            result.append('/').append(dir);
        }

        return result.toString();
    }
}

// First thoughts:

class Solution {
    public String simplifyPath(String path) {

        Queue<StringBuilder> queue = new LinkedList<>();

        int i = 0;

        int len = path.length();
        
        while(i < len)
        {
            if(path.charAt(i) == '/' || (path.charAt(i) == '/' && path.charAt(i+1) == '/'))
            {
                int j = i;

                while(j < len && path.charAt(j) == '/') j++;

                StringBuilder string = new StringBuilder();

                while(j < len && path.charAt(j) != '/')
                {
                    System.out.println(path.charAt(j));

                    string.append(path.charAt(j));
                    j++;
                }

                if(string.length() > 0 && string.charAt(0) == '/') string.deleteCharAt(0);

                if(string.equals("..")) queue.remove(queue.size() - 1);

                else queue.add(string);

                i = j;

            }

            i++;
        }

        StringBuilder s = new StringBuilder();

        s.append('/');

        while(!queue.isEmpty())
        {
            s.append(queue.remove().toString());
            s.append('/');
        }

        s.deleteCharAt(s.length()-1);

        return s.toString();
    }
}