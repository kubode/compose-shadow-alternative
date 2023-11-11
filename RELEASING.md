# Releasing

1. Update the `version` in [`gradle.properties`](./gradle.properties) to the release version.

2. Commit changes.

   ```shell
   $ git commit -am "Prepare version X.Y.X"
   ```

3. Tag the release.

   ```shell
   $ git tag -am "Version X.Y.Z" X.Y.Z
   ```
   
4. Push the tag.

   ```shell
   $ git push --tags
   ```

5. Update the `version` in [`gradle.properties`](./gradle.properties) to the next `SNAPSHOT` version.

6. Commit changes.

   ```shell
   $ git commit -am "Prepare next development version"
   ```

7. Push changes.

   ```shell
   $ git push
   ```

   This will trigger a GitHub Action to publish the library to Maven Central.
