class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character> charStack = new Stack<>();
        Map<Character, Character> CtO= new HashMap<>();
        CtO.put(')','(');
        CtO.put('}','{');
        CtO.put(']','[');
        for(char c:s.toCharArray())
        {
            if(CtO.containsKey(c))
            {
                if(!charStack.isEmpty() && charStack.peek()==CtO.get(c))
                    charStack.pop();
                else
                    return false;
            }
            else
            {
                charStack.push(c);
            }
        }
        return charStack.isEmpty();
    }
}
