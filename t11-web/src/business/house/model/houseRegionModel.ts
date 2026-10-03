
interface HouseRegionParam {
    id: any
    name: any
}
interface HouseRegionEntity {
    id: any
    code: any
    name: any
    shortName: any
    landArea: any
    constructionArea: any
    roadArea: any
    greenArea: any
    constructionNum: any
    ownerStatus: any
    estateCardGroupId: any
    sortNum: any
}
interface HouseRegionRelateList {
}
function createHouseRegionParam(): HouseRegionParam{
    return {
       id: '',
       name: '',
    }
}
function createHouseRegionEntity(): HouseRegionEntity{
    return {
       id: '',
       code: '',
       name: '',
       shortName: '',
       landArea: '',
       constructionArea: '',
       roadArea: '',
       greenArea: '',
       constructionNum: '',
       ownerStatus: '',
       estateCardGroupId: '',
       sortNum: '',
    }
}
export function useHouseRegionModel(){
    return { createHouseRegionParam, createHouseRegionEntity,
     }
}
export type { HouseRegionParam, HouseRegionEntity, HouseRegionRelateList }


