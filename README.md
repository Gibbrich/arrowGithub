# arrowGithub

## Project description:
App fetches repositories from Github via API on start up. 
There are 2 screens: list of repositories screen and repository details screen.
On clicking repository in repository list screen opens repository details screen.

Target: eliminate presenter/usecase/repository classes using FP approach (particularly using Arrow library)

Problem: GithubDataRepository class caches list of fetched repositories. 
Cached values are used both in repositories screen and repository details screen.
Assume, that we can't pass repository between screens, so on repository details screen we need fetch repository by its id from GithubDataRepository cache.

Questions:
GithubDataRepository has cache and app depends on the state of it. We must be sure, that when we working on repository details screen we have cache initialized. 
1) How to handle this problem in functional style?
2) Where to store this cache?
