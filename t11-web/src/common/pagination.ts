export function changeActive(index: number) {
    const links = document.querySelectorAll('#paginationList .page-link');
    let activeIndex = 0;

    links.forEach((link, i) => {
        if (link.classList.contains('active')) {
            activeIndex = i;
        }
    });

    links.forEach((link, i) => {
        if (i === index && index !== 0 && index !== 3) {
            link.classList.add('active');
        } else {
            link.classList.remove('active');
        }
    });

    if (index === 0) {
        console.log(index);
        const prevIndex = activeIndex - 1;
        if (prevIndex >=1) {
            links[prevIndex].classList.add('active');
        }
        else
            links[1].classList.add('active');
    } else {
        links[index].classList.add('active');
    }

    if (index === 4) {
        const nextIndex = activeIndex + 1;
        if (nextIndex <=3) {
            links[nextIndex].classList.add('active');
        }
        else
            links[3].classList.add('active');
    } else {
        links[index].classList.add('active');
    }
}
