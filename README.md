# ProjetoHotelFEI
Projeto dos alunos Alexandre Cardoso Feitosa, Filipi Guimarães Silva e Lucas Machado Serain, graduandos do 4º Semestre de Ciência da Computação na FEI.

-- Tutorial de Uso Correto do Nosso Aplicativo

O apk se encontra em APP > release > apk_ProjetoHotelFEI.apk

----> Usuários Iniciais
Visando a facilidade ao testar o aplicativo, criamos alguns usuários padrões para que você logue
pela primeira vez, são eles:

Administrador (Dono)
Usuário: admin
Senha: admin

Usuário (Cliente)
Usuário: user
Senha: user

Porém, nada impede que você crie seu próprio usuário. 
Obs.: Os usuários Administradores são criadas a partir do primeiro administrador.
Imagine isso como se você fosse o dono do Hotel, cadastrando seu novo estagiário.

----> Ambiente
Para a simulação perfeita de um ambiente de reservas, separamos nosso projeto em duas frentes:
A interface do administrador (que seria o dono ou funcionário do Hotel).
E a interface do usuário (que seria um cliente que está buscando um quarto naquele hotel).
Começaremos falando sobre o Ambiente do Usuário.

----> Quartos
Ao rodar o programa, criamos alguns quartos para que seja possível a navegação.
O usuário pode navegar entre os quartos disponíveis arrastando para a direita e selecionar o desejado clicando em "Detalhes do Quarto".
Logo ao clicar, o usuário tem o overview do quarto, com suas principais informações e sua imagem.
Caso goste, ele pode rolar um pouco a tela e clicar em "Reservar".

----> Reserva
Ao reservar um quarto, o cliente deve selecionar o período em que ele deseja ficar hospedado e verificar a disponibilidade.
Caso o quarto esteja disponível naquele intervalo, é possível estimar o valor que deverá ser pago pelo quarto em questão.
Após análisar o preço, o cliente pode reservar o quarto clicando em "Reservar".

----> Avaliações
Imaginando um cenário onde o cliente já usufruiu do quarto, o usuário pode avaliar o quarto e deixar um descrição, que será mostrada ao detalhar o Quarto.

----> Minhas Informações
O Ambiente também possui uma interface onde o usuário pode alterar suas informações principais, inclusive sua senha.

Agora falaremos um pouco sobre a interface do administrador.

----> Estrutura
Ao logar, o Administrador depara três opções: Estrutura, Novo Funcionário e Check-In/Check-Out.
Clicando em Estrutura, o Administrador consegue visualizar todos os quartos já criados em seu hotel.
Além disso, clicando em um dos quartos, o Administrador consegue alterar as informações deste quarto ou até mesmo exclui-lo.
O Administrador também pode inserir um novo quarto nesta tela.

----> Novo Funcionário
Pensando num crescimento do hotel, temos a tela de cadastro de um novo funcionário, onde o Administrador pode inserir mais logins Administradores.

----> Check-In/Check-Out
Imaginando o funcionamento do hotel, o Administrador, ao receber o cliente, pode fazer o Check-IN ou Check-OUT.
Para isso, basta verificar todas as reservas feitas ou pesquisar pelas reservas do Usuário em questão.
Após isso, o administrador pode confirmar a alteração de status.


Estruturas Usadas:

ÁRVORE -> Utilizada para armazenar os clientes e administradores cadastrados.
HASH -> Utilizada para armazenar o calendário de reservas dos Hotel.
LDE -> Utilizada em conjunto com a HASH para armazenar as reservas. Também é utilizada em outras áreas do programa como os Quartos e Avaliações.
LES -> Utilizada para o armazenamento das Imagens.
