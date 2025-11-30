1. Setup all the project in single folder.
2. Set up GIT for the VSS workspace
	2.1 Create  a repo called VSS_GIT_workspace with branch called PROD
	2.2  Add a dummy readMe.txt file
	2.3 git init, git commit , git branch -M PROD
	2.4 git remote add origin "https://token@github.com/karthikc3086-org/VSS_GIT_workspace.git"  [do not mention token incase you want to commit the file]
	2.5 git push origin PROD
3. Now create one more GIT branch called PRE-ROD (Based on PROD which is default branch)
4. Create branch protection for PROD:   Settings → Branches → Branch protection rules → Add Branch ruleset.
    Branch rules
	Restrict creations: Only allow users with bypass permission to create matching refs.
	Restrict updates: Only allow users with bypass permission to update matching refs.
	Restrict deletions: Only allow users with bypass permissions to delete matching refs.
	Require linear history: Prevent merge commits from being pushed to matching refs.
	Require a pull request before merging
		Required approvals:1  [The number of approving reviews that are required before a pull request can be merged.]
	Block force pushes: Prevent users with push access from force pushing to refs.
    Added roles in "Bypass list"  : Repository Admin , Maintain
    Target branches : Default
5. git fetch, git branch -M PRE-PROD
6. Creating one more user with Maintainer access to review it
7. Changes pushed ot PRE-PROD by maintainer user.
8. PULL request created by karthiksekaran and then approved by karthikc
9. Attempt to push one change and create pull request.
  git checkout PRE-PROD
git fetch origin
git merge origin/PROD        # or: git rebase origin/PROD
git push --set-upstream origin PRE-PROD
git push
