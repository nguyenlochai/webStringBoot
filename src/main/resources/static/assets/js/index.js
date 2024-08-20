// slide
const listImage = document.querySelector('.slide__list-img')
const imgs = document.getElementsByTagName('img')
let currennt = 0;
const length = imgs.length
const btnleft = document.querySelector('.btn-left')
const btnright = document.querySelector('.btn-right')

const handleChangeSlide = () => {
    if(currennt == length - 7){
        currennt = 0
        let width = imgs[0].offsetWidth
        listImage.style.transform = `translateX(0px)`
        document.querySelector('.index-item__active').classList.remove('index-item__active')
        document.querySelector('.index-item-'+currennt).classList.add('index-item__active')
    } else {
        currennt ++
        let width = imgs[0].offsetWidth
        listImage.style.transform = `translateX(${width*3.5 *currennt}px)`
        document.querySelector('.index-item__active').classList.remove('index-item__active')
        document.querySelector('.index-item-' + currennt).classList.add('index-item__active')
    }
}

let handleaEventChaneSlide = setInterval(handleChangeSlide, 2000)

btnleft.addEventListener('click', ()=>{
    clearInterval(handleaEventChaneSlide)
    handleChangeSlide()
    handleaEventChaneSlide = setInterval(handleChangeSlide, 2000)
})

btnright.addEventListener('click', ()=>{
    clearInterval(handleaEventChaneSlide)
    if(currennt = 0){
        currennt == length - 7
        let width = imgs[0].offsetWidth
        listImage.style.transform = `translateX(${width * -1 * currennt}px)`
    } else {
        currennt --
        let width = imgs[0].offsetWidth
        listImage.style.transform = `translateX(${width*3.5 *currennt}px)`
    }
    handleaEventChaneSlide = setInterval(handleChangeSlide, 2000)
})




