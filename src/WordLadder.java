import java.util.*;

public class WordLadder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Set<String> set=new HashSet<>(wordList);
        int level=1;
        if(!set.contains(endWord))
        {
            return 0;
        }
        Queue<String> que=new LinkedList<>();
        que.offer(beginWord);
        while(!que.isEmpty())
        {
            int  n= que.size();

            for (int i = 0; i <n ; i++)
            {
                String s=que.poll();

                for (int j = 0; j < s.length(); j++)
                {
                    char[] letter=s.toCharArray();
                    for(char ch='a' ;ch<='z';ch++)
                    {
                        letter[j]=ch;
                        String newword=new String(letter);
                        if(endWord.equals(newword))
                        {
                            return level +1;
                        }
                        if(set.contains(newword))
                        {
                            que.offer(newword);
                            set.remove(newword);

                        }

                    }

                }


            }
            level++;
        }
        return 0;



    }
}
