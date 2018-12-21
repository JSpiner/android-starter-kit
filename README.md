# What is ASK(Android-Starter-Kit)?
Android 프로젝트를 빠르게 만들기위한 Starter-kit
MVVM 기본구조와 각종 유틸을 포함함.

### how to start?
```
$ git submodule add https://github.com/JSpiner/android-starter-kit.git
$ git submodule update --init
Add `android-starter-kit` module to your Android project.
```

### how to edit ask module?
```
$ cd <YOUR-PROJECT-ROOT>/android-starter-kit
$ git add <FILES>
$ git commit -m <MESSAGE>
$ git push 
```

### how to save new ask revision to root project?
```
// after commit
$ cd <YOUR-PROJECT-ROOT>
$ git add android-starter-kit
$ git commit -m "apply new revision"
```

### how to fetch new ask revision to root project?
```
// saved revision
$ git submodule update --init
// latest revision
$ git submodule update --remote
```

### it supports
- RxJava Lifecycle Managing
- RxJava based MVVM
- Base View Component
  - Activity, Fragment, View
- Databinding
