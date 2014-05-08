# android-preferences

An easier way to use and consolidate preferense in your Android project. Based off of
[Jake Wharton](https://github.com/JakeWharton)'s preferences in
[u2020](https://github.com/JakeWharton/u2020)

## Usage

It's best to set up a way to ensure only one instance of each preference will be available in your
application. This can best be done by using [Dagger[(https://github.com/square/dagger) (see
[u2020](https://github.com/JakeWharton/u2020/blob/master/src/debug/java/com/jakewharton/u2020/data/DebugDataModule.java)
for an example) but can also be done with an overridden Application class (see [sample]
(https://github.com/InkApplications/android-preferences/blob/master/preferences-sample/src/main/java/com/inkapplications/preferences/sample/SampleApplication.java)

For more info see the sample and [JavaDocs](inkapplications.github.io/android-preferences)

## License

    Copyright 2014 Andrew Reitz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.