from collections import *
from typing import *


def autoSuggestion(n: int, S: List[str], l: int, P: str) -> List[List[str]]:
    trie = Trie()
    trie.add_all_words( S )
    ans = []
    
    
    for i in range( len( P ) ):
        trie = trie.children[P[i]]
        suggestions = []
        trie.get_suggestions( suggestions, P[:i + 1] )
        ans.append( suggestions )


    return ans






class Trie:

    def __init__( self ):
        self.children = defaultdict( Trie )
        self.is_a_word = False




    def add_word( self, word ):

        if word == "":
            self.is_a_word = True


            return

        self.children[word[0]].add_word( word[1:] )




    def add_all_words( self, words ):

        
        for word in words:
            self.add_word( word )




    def get_suggestions( self, suggestions, s):

        if self.is_a_word:
            suggestions.append( s )

            if len( suggestions ) == 3:
                return

        
        for ch in sorted( self.children ):
            self.children[ch].get_suggestions( suggestions, s + ch )

            if len( suggestions ) == 3:
                return
