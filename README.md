# Pipeline Deployment

__IMPORTANT__: This pipeline does not support job _UPDATE_, for any update, please deleted related jobs first before running this pipeline in order to _CREATE_ new ones

## How does this work?

This pipeline automatically _CREATE_ folders and jobs based on pre-defined variables inside file `job-dsl`, which are 

`targetFolders` - a list of primary folders (by environment)

`targetJobs` - a list of all microservices with a strict format
```sh
<microserviceType>/<microserviceName>
```

## Basic Template Structure by Environment

By default, primary folder template is set to `./pipeline-template/folder-structure`

For microservice, template can be found at `./pipeline-template/template-<env>`. There are two types of template, which are;

#### Microservice
__DEV__ : Build and Deploy jobs

__SIT__ : Build and Deploy jobs

__UAT__ : Build and Deploy jobs

__PFM__ : Deploy job _only_

__STG__ : Deploy job _only_

__PRD__ : Deploy job _only_

#### Front End
__ALL__ : Deploy _only_

## Simple Usage

1. Edit `targetFolders` and `targetJobs` to the desired state.
2. Edit related template(s) to the desired state
3. _DELETE_ the target jobs in order to recreate.
4. Run `./pipeline-deployment` to _CREATE_ jobs

