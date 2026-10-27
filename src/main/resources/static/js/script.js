// ===== Menu mobile =====
const btnMenu = document.getElementById('btnMenu')
const navLinks = document.getElementById('navLinks')

btnMenu.addEventListener('click', () => {
    navLinks.classList.toggle('aberto')
})

// Fecha o menu ao clicar em um link
navLinks.querySelectorAll('a').forEach(link => {
    link.addEventListener('click', () => navLinks.classList.remove('aberto'))
})

// ===== Tema claro / escuro =====
const btnTema = document.getElementById('btnTema')

function aplicarTema(tema) {
    document.body.classList.toggle('escuro', tema === 'escuro')
    btnTema.textContent = tema === 'escuro' ? '☀️' : '🌙'
}

// Lembra o tema escolhido pelo usuário
let temaSalvo = 'claro'
try { temaSalvo = localStorage.getItem('tema') || 'claro' } catch (e) {}
aplicarTema(temaSalvo)

btnTema.addEventListener('click', () => {
    const novoTema = document.body.classList.contains('escuro') ? 'claro' : 'escuro'
    aplicarTema(novoTema)
    try { localStorage.setItem('tema', novoTema) } catch (e) {}
})

// ===== Filtro de projetos =====
const botoesFiltro = document.querySelectorAll('.filtro')
const cardsProjeto = document.querySelectorAll('.card-projeto')

botoesFiltro.forEach(botao => {
    botao.addEventListener('click', () => {
        botoesFiltro.forEach(b => b.classList.remove('ativo'))
        botao.classList.add('ativo')

        const filtro = botao.dataset.filtro
        cardsProjeto.forEach(card => {
            const mostrar = filtro === 'todos' || card.dataset.categoria === filtro
            card.classList.toggle('escondido', !mostrar)
        })
    })
})

// ===== Contador de caracteres da mensagem =====
const campoMensagem = document.getElementById('mensagem')
const contador = document.getElementById('contador')

campoMensagem.addEventListener('input', () => {
    contador.textContent = campoMensagem.value.length
})

// ===== Link ativo no menu conforme a rolagem =====
const secoes = document.querySelectorAll('main section')
const linksMenu = document.querySelectorAll('.nav-links a')
const voltarTopo = document.getElementById('voltarTopo')

window.addEventListener('scroll', () => {
    let atual = 'inicio'
    secoes.forEach(secao => {
        if (window.scrollY >= secao.offsetTop - 120) {
            atual = secao.id
        }
    })

    linksMenu.forEach(link => {
        link.classList.toggle('ativo', link.getAttribute('href') === '#' + atual)
    })

    // Mostra o botão "voltar ao topo" depois de rolar um pouco
    voltarTopo.classList.toggle('visivel', window.scrollY > 400)
})

voltarTopo.addEventListener('click', () => {
    window.scrollTo({ top: 0, behavior: 'smooth' })
})

// ===== Animação: elementos aparecem ao rolar a página =====
const elementosAnimados = document.querySelectorAll('.card-habilidade, .card-projeto, .card-info, .form-contato')
elementosAnimados.forEach(el => el.classList.add('revelar'))

const observador = new IntersectionObserver(entradas => {
    entradas.forEach(entrada => {
        if (entrada.isIntersecting) {
            entrada.target.classList.add('visivel')
            observador.unobserve(entrada.target)
        }
    })
}, { threshold: 0.15 })

elementosAnimados.forEach(el => observador.observe(el))

// ===== Some com a mensagem de sucesso depois de alguns segundos =====
const alerta = document.querySelector('.alerta-sucesso')
if (alerta) {
    setTimeout(() => alerta.remove(), 5000)
}
