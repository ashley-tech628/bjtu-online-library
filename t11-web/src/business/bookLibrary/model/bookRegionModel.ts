
interface BookLibraryParam {
    id: any
    title: any
}
interface BookLibraryEntity {
    id: any
    title: any
    author: any
    type: any
    publicationTime: any
    cover: any
    description: any
}
interface BookLibraryRelateList {
}
function createBookLibraryParam(): BookLibraryParam{
    return {
        id: '',
        title: '',
    }
}
function createBookLibraryEntity(): BookLibraryEntity{
    return {
        id: '',
        title:  '',
        author:  '',
        type: '',
        publicationTime: '',
        cover:  '',
        description: '',
    }
}
export function useBookLibraryModel(){
    return { createBookLibraryParam, createBookLibraryEntity,
    }
}
export type { BookLibraryParam, BookLibraryEntity, BookLibraryRelateList }


