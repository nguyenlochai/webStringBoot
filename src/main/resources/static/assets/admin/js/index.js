// đóng form thêm sản phẩm  , loại sản phẩm
//const iconClose = document.querySelector('.form__icon-close');
//const modal = document.querySelector('.modal');
//
//
//iconClose.addEventListener('click', () => {
//    modal.style.display = 'none';
//
//});



// // mở form thêm sản phẩm
// const addProduct = document.querySelector('.grid__column-menu-item-link-product')
// addProduct.addEventListener('click', () => {
//     modalAddproduct.style.display = "block"
// });

// // mở form thêm loại sản phẩm
// const addCategory = document.querySelector('.grid__column-menu-item-link-category')
// addProduct.addEventListener('click', () => {
//     modalAddCategory.style.display = "block"
// });


// trả về url
const iconClose = document.querySelector('.form__icon-close');
const modal = document.querySelector('.modal');


iconClose.addEventListener('click', () => {
    window.location.href = '/admin/home';

});