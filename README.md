![Fire](logo.png)

Refactor from [Timber][timber].

Modification:

1. support custom map log content.
2. add log ext fun.
3. no support lint.(lint todo)

This is a logger with a small, extensible API which provides utility on top of Android's normal
`Log` class.

I copy this class into all the little apps I make. I'm tired of doing it. Now it's a library.

Behavior is added through `Flame` instances. You can install an instance by calling `Fire.burn`.
Installation of `Flame`s should be done as early as possible. The `onCreate` of your application is
the most logical choice.

The `DebugFlame` implementation will automatically figure out from which class it's being called and
use that class name as its tag. Since the tags vary, it works really well when coupled with a log
reader like [Pidcat][pidcat].

There are no `Flame` implementations installed by default because every time you log in production, a
puppy dies.


Usage
-----

Two easy steps:

 1. Install any `Flame` instances you want in the `onCreate` of your application class.
 2. Call `Fire`'s static methods everywhere throughout your app.

Check out the sample app in `fire-sample/` to see it in action.


Download
--------

```groovy
implementation 'io.github.codepoem:fire:1.0.3'
```


License
-------

    Copyright 2021 CodePoem

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [timber]: http://github.com/JakeWharton/timber/
 [pidcat]: http://github.com/JakeWharton/pidcat/
