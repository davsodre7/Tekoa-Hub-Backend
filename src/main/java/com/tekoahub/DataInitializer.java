package com.tekoahub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tekoahub.model.Content;
import com.tekoahub.model.Category;
import com.tekoahub.repository.ContentRepository;
import com.tekoahub.repository.CategoryRepository;

@Configuration
public class DataInitializer {

	@Bean
	public CommandLineRunner initDatabase(ContentRepository contentRepository, CategoryRepository categoryRepository) {
		return args -> {
			if (categoryRepository.count() == 0) {
				Category historias = categoryRepository.save(Category.builder()
					.name("Histórias e Lendas")
					.description("Narrativas tradicionais e lendas dos povos indígenas")
					.color("#8B4513")
					.build()
				);

				Category artesanato = categoryRepository.save(Category.builder()
					.name("Artesanato")
					.description("Artes manuais e técnicas tradicionais")
					.color("#CD853F")
					.build()
				);

				Category musica = categoryRepository.save(Category.builder()
					.name("Música e Dança")
					.description("Expressões musicais e danças rituais")
					.color("#D2691E")
					.build()
				);

				Category rituais = categoryRepository.save(Category.builder()
					.name("Rituais e Cerimônias")
					.description("Práticas rituais e cerimônias tradicionais")
					.color("#A0522D")
					.build()
				);

				Category linguagem = categoryRepository.save(Category.builder()
					.name("Linguagem e Comunicação")
					.description("Línguas indígenas e formas de comunicação")
					.color("#DEB887")
					.build()
				);

				System.out.println("Categorias de exemplo inseridas na tabela categories.");
			}

			if (contentRepository.count() == 0) {
				Category historias = categoryRepository.findByName("Histórias e Lendas").orElse(null);
				Category artesanato = categoryRepository.findByName("Artesanato").orElse(null);
				Category musica = categoryRepository.findByName("Música e Dança").orElse(null);
				Category rituais = categoryRepository.findByName("Rituais e Cerimônias").orElse(null);
				Category linguagem = categoryRepository.findByName("Linguagem e Comunicação").orElse(null);

				contentRepository.save(Content.builder()
					.title("Uirapuru: O Pássaro Místico")
					.description("O uirapuru é uma ave lendária da Amazônia, conhecida por seu canto melodioso que, segundo a crença indígena, traz felicidade e sorte. Existem muitas lendas sobre a origem e o poder desse pássaro mágico.")
					.type("story")
					.ethnicity("Diversas")
					.region("Amazônia")
					.imageUrl("/assets/Uirapuru.jpg")
					.creator("Anônimo")
					.category(historias)
					.build()
				);

				contentRepository.save(Content.builder()
					.title("Arte Marajoara: Cerâmica da Ilha")
					.description("A arte marajoara é uma expressão cultural dos antigos habitantes da Ilha de Marajó, no Pará. Caracteriza-se por sua cerâmica elaborada, com padrões geométricos e zoomorfos, que refletem a complexidade social e a cosmovisão desses povos.")
					.type("craft")
					.ethnicity("Marajoara")
					.region("Norte")
					.imageUrl("/assets/marajoara.jpg")
					.creator("Anônimo")
					.category(artesanato)
					.build()
				);

				contentRepository.save(Content.builder()
					.title("Toré dos Fulni-ô: Dança Sagrada")
					.description("O Toré é uma dança ritualística presente em diversas etnias indígenas do Nordeste do Brasil. Para os Fulni-ô, de Pernambuco, o Toré é uma forma de conexão com os ancestrais e a natureza, fundamental para a manutenção de sua cultura e espiritualidade.")
					.type("music")
					.ethnicity("Fulni-ô")
					.region("Nordeste")
					.imageUrl("/assets/Toré-dos-Fulni-ô.jpg")
					.creator("Anônimo")
					.category(musica)
					.build()
				);

				contentRepository.save(Content.builder()
					.title("Mandioca: Raiz da Vida Indígena")
					.description("A mandioca, também conhecida como aipim ou macaxeira, é um alimento básico para muitas etnias indígenas do Brasil. Dela se extrai a farinha, o tucupi, a tapioca e outros produtos essenciais para a culinária e subsistência.")
					.type("story")
					.ethnicity("Diversas")
					.region("Todas as Regiões")
					.imageUrl("/assets/mandioca.jpg")
					.creator("Anônimo")
					.category(historias)
					.build()
				);

				contentRepository.save(Content.builder()
					.title("Trançado Yanomami: Arte da Floresta")
					.description("O trançado é uma arte milenar entre os Yanomami, povo que habita a floresta amazônica na fronteira entre Brasil e Venezuela. Cestas, peneiras e adornos são confeccionados com fibras naturais, revelando um profundo conhecimento da flora local e uma estética única.")
					.type("craft")
					.ethnicity("Yanomami")
					.region("Norte")
					.imageUrl("/assets/Trançado-Yanomami.jpg")
					.creator("Anônimo")
					.category(artesanato)
					.build()
				);

				contentRepository.save(Content.builder()
					.title("Pintura Corporal Kadiwéu: A Arte de Ser")
					.description("A pintura corporal Kadiwéu, do Mato Grosso do Sul, é um dos mais belos exemplos da arte indígena brasileira. Feita com jenipapo e urucum, cada traço e padrão possui significados que expressam identidade, status social e rituais.")
					.type("craft")
					.ethnicity("Kadiwéu")
					.region("Centro-Oeste")
					.imageUrl("/assets/Pintura-Corporal-Kadiwéu.jpg")
					.creator("Anônimo")
					.category(artesanato)
					.build()
				);

				contentRepository.save(Content.builder()
					.title("Ritual do Quarup: A Celebração da Vida e Morte")
					.description("O Quarup é um ritual de homenagem aos mortos célebres, praticado pelos povos do Alto Xingu, no Mato Grosso. É uma grande celebração que envolve danças, cantos, lutas e a troca de presentes, reafirmando os laços comunitários e o ciclo da vida.")
					.type("ritual")
					.ethnicity("Kuikuro")
					.region("Centro-Oeste")
					.imageUrl("/assets/Ritual-do-Quarup.jpeg")
					.creator("Anônimo")
					.category(rituais)
					.build()
				);

				contentRepository.save(Content.builder()
					.title("Língua Guarani: Herança Viva")
					.description("A língua Guarani é falada por milhões de pessoas na América do Sul, sendo oficial no Paraguai. Para os Guarani, a língua é a expressão máxima de sua cultura e identidade, transmitindo conhecimentos ancestrais e cosmovisões.")
					.type("language")
					.ethnicity("Guarani")
					.region("Sul e Sudeste")
					.imageUrl("/assets/Língua-Guarani.jpg")
					.creator("Anônimo")
					.category(linguagem)
					.build()
				);

				System.out.println("Dados de exemplo inseridos na tabela content_items.");
			} else {
				System.out.println("A tabela content_items já contém dados. Ignorando a inserção de dados de exemplo.");
			}
		};
	}
}