-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: usafarmers
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
use heroku_5e0d7e7e22cf8ec;
--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `user_id` bigint NOT NULL,
  `address_line1` varchar(200) DEFAULT NULL,
  `address_line2` varchar(200) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `zip_code` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK6i66ijb8twgcqtetl8eeeed6v` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'ercan','ercan','ercan','No Information','No Information');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk91upmbueyim93v469wj7b2qh` (`user_id`),
  CONSTRAINT `FKk91upmbueyim93v469wj7b2qh` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'ROLE_USER',1);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `comment_id` bigint NOT NULL AUTO_INCREMENT,
  `comment_details` text,
  `created_date` datetime(6) DEFAULT NULL,
  `message_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK6mrnbfthapvp365xmtrpojpu2` (`message_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  CONSTRAINT `FK6mrnbfthapvp365xmtrpojpu2` FOREIGN KEY (`message_id`) REFERENCES `messages` (`message_id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'ercan','2022-05-22 20:16:09.832812',1,1);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `message_id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `message_content` text,
  `message_title` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `FKpsmh6clh3csorw43eaodlqvkn` (`user_id`),
  CONSTRAINT `FKpsmh6clh3csorw43eaodlqvkn` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'2022-05-22 20:16:04.645012','ercanercan','ercan',1);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nutrients`
--

DROP TABLE IF EXISTS `nutrients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `nutrients` (
  `nutriend_id` bigint NOT NULL AUTO_INCREMENT,
  `description` text,
  `nutrientname` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nutriend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nutrients`
--

LOCK TABLES `nutrients` WRITE;
/*!40000 ALTER TABLE `nutrients` DISABLE KEYS */;
INSERT INTO `nutrients` VALUES (1,'A part of every living cell, Nitrogen is essential to plant growth. Learn about the many roles this critical nutrient plays, including being a necessary component for chlorophyll synthesis and directly increasing protein content in plants.A part of every living cell, Nitrogen is essential to plant growth. Learn about the many roles this critical nutrient plays, including being a necessary component for chlorophyll synthesis and directly increasing protein content in plants.A part of every living cell, Nitrogen is essential to plant growth. Learn about the many roles this critical nutrient plays , including being a necessary component for chlorophyll synthesis and directly increasing protein content in plants.A part of every living cell, Nitrogen is essential to plant growth. Learn about the many roles this critical nutrient plays, including being a necessary component for chlorophyll synthesis and directly increasing protein content in plants.','N','NITROGEN'),(2,'Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.Without phosphorus, no plant can complete its normal production cycle. Find out why Phosphorus is often referred to as the \"energizer,\" and how its many roles make it one of the three primary nutrients for plant growth.','P','PHOSPHORUS'),(3,'From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.From photosynthesis, to protein synthesis and more, Potassium is absolutely vital to the success of your crops. Discover why K earns its place in the \"holy trinity\" of Macronutrients (NPK) in our Nutrient Knowledge breakdown.','K','POTASSIUM'),(4,'Hidden in the heart of each chlorophyll molecule is an atom of Magnesium. Learn how this unique nutrient plays an integral role in everything from photosynthesis, to phosphate metabolism to plant respiration and the activation of enzyme systems.Hidden in the heart of each chlorophyll molecule is an atom of Magnesium. Learn how this unique nutrient plays an integral role in everything from photosynthesis, to phosphate metabolism to plant respiration and the activation of enzyme systems.Hidden in the heart of each chlorophyll molecule is an atom of Magnesium. Learn how this unique nutrient plays an integral role in everything from photosynthesis, to phosphate metabolism to plant respiration and the activation of enzyme systems.Hidden in the heart of each chlorophyll molecule is an atom of Magnesium. Learn how this unique nutrient plays an integral role in everything from photosynthesis, to phosphate metabolism to plant respiration and the activation of enzyme systems.','Mg','MAGNESIUM'),(5,'Sulfur is a part of every living cell and is important to the formation of proteins, yet it is often present in insufficient quantities for the needs of high-yielding crops. Explore how and when Sulfur can be used to get the most out of your crop.Sulfur is a part of every living cell and is important to the formation of proteins, yet it is often present in insufficient quantities for the needs of high-yielding crops. Explore how and when Sulfur can be used to get the most out of your crop.Sulfur is a part of every living cell and is important to the formation of proteins, yet it is often present in insufficient quantities for the needs of high-yielding crops. Explore how and when Sulfur can be used to get the most out of your crop.Sulfur is a part of every living cell and is important to the formation of proteins, yet it is often present in insufficient quantities for the needs of high-yielding crops. Explore how and when Sulfur can be used to get the most out of your crop.','S','SULFUR'),(6,'Calcium is found all around us, and the very existence of plants and animals depends on it. Find out why this underrated secondary nutrient is one that should never be ignored.Calcium is found all around us, and the very existence of plants and animals depends on it. Find out why this underrated secondary nutrient is one that should never be ignored.Calcium is found all around us, and the very existence of plants and animals depends on it. Find out why this underrated secondary nutrient is one that should never be ignored.','Ca','CALCIUM'),(7,'Discover why Boron is essential for cell wall formation and rapid growing points within plants, and the impact that can have on improving plant health.Discover why Boron is essential for cell wall formation and rapid growing points within plants, and the impact that can have on improving plant health.Discover why Boron is essential for cell wall formation and rapid growing points within plants, and the impact that can have on improving plant health.Discover why Boron is essential for cell wall formation and rapid growing points within plants, and the impact that can have on improving plant health.','B','BORON'),(8,'Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.Even though it\'s only needed in small quantities, Chlorine is a required component for all plants. Learn how this valuable micronutrient is active in everything from energy reactions, to regulating stomatal regulation.','Cl','CHLORINE'),(9,'With the power to accelerate germination and maturity, while increasing Phosphorus and Calcium availability, Manganese is one micronutrient with giant benefits.With the power to accelerate germination and maturity, while increasing Phosphorus and Calcium availability, Manganese is one micronutrient with giant benefits.With the power to accelerate germination and maturity, while increasing Phosphorus and Calcium availability, Manganese is one micronutrient with giant benefits.With the power to accelerate germination and maturity, while increasing Phosphorus and Calcium availability, Manganese is one micronutrient with giant benefits.','Mn','MANGANESE'),(10,'From energy transfer, nitrogen reduction and fixation, to lignin formation, learn how Iron is a key component of the enzymes essential for growth and food production.From energy transfer, nitrogen reduction and fixation, to lignin formation, learn how Iron is a key component of the enzymes essential for growth and food production.From energy transfer, nitrogen reduction and fixation, to lignin formation, learn how Iron is a key component of the enzymes essential for growth and food production.From energy transfer, nitrogen reduction and fixation, to lignin formation, learn how Iron is a key component of the enzymes essential for growth and food production.','Fe','IRON'),(11,'It may only be needed in very small amounts, but without Nickel, urea conversion is impossible, making it an important part of Nitrogen metabolism. Learn more about this recent addition to the list of essential plant nutrients.It may only be needed in very small amounts, but without Nickel, urea conversion is impossible, making it an important part of Nitrogen metabolism. Learn more about this recent addition to the list of essential plant nutrients.It may only be needed in very small amounts, but without Nickel, urea conversion is impossible, making it an important part of Nitrogen metabolism. Learn more about this recent addition to the list of essential plant nutrients.It may only be needed in very small amounts, but without Nickel, urea conversion is impossible, making it an important part of Nitrogen metabolism. Learn more about this recent addition to the list of essential plant nutrients.','Ni','NICKEL'),(12,'It may only be needed in very small amounts, but without Nickel, urea conversion is impossible, making it an important part of Nitrogen metabolism. Learn more about this recent addition to the list of essential plant nutrients.It may only be needed in very small amounts, but without Nickel, urea conversion is impossible, making it an important part of Nitrogen metabolism. Learn more about this recent addition to the list of essential plant nutrients.It may only be needed in very small amounts, but without Nickel, urea conversion is impossible, making it an important part of Nitrogen metabolism. Learn more about this recent addition to the list of essential plant nutrients.It may only be needed in very small amounts, but without Nickel, urea conversion is impossible, making it an important part of Nitrogen metabolism. Learn more about this recent addition to the list of essential plant nutrients.','Cu','COPPER'),(13,'Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.Want high-yields? Then you\'re gonna need a little Zinc. Find out why this incredible micronutrient was one of the first to be recognized as essential for plants and plant growth.','Zn','ZINC'),(14,'It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.It may be just a trace element found in the soil, but it\'s absolutely required for the synthesis and activity of the enzyme nitrate reductase. Learn why Molybdenum is so important for optimizing plant growth.','Mo','MOLYBDENUM'),(15,'One of the major building blocks of life, Hydrogen is one of three primary elements plants use in the largest amounts. Learn more about its role in plant growth.One of the major building blocks of life, Hydrogen is one of three primary elements plants use in the largest amounts. Learn more about its role in plant growth.One of the major building blocks of life, Hydrogen is one of three primary elements plants use in the largest amounts. Learn more about its role in plant growth.One of the major building blocks of life, Hydrogen is one of three primary elements plants use in the largest amounts. Learn more about its role in plant growth.','H','HYDROGEN'),(16,'Carbon is responsible for all life on earth. Explore how plants use CO? from the atmosphere to build essential biological compounds such as carbohydrates and proteins.Carbon is responsible for all life on earth. Explore how plants use CO? from the atmosphere to build essential biological compounds such as carbohydrates and proteins.Carbon is responsible for all life on earth. Explore how plants use CO? from the atmosphere to build essential biological compounds such as carbohydrates and proteins.Carbon is responsible for all life on earth. Explore how plants use CO? from the atmosphere to build essential biological compounds such as carbohydrates and proteins.','C','CARBON'),(17,'Oxygen is responsible for cellular respiration in plants. Learn more about the role of this critical element in photosynthesis, and how it is both stored for energy and released as a byproduct.Oxygen is responsible for cellular respiration in plants. Learn more about the role of this critical element in photosynthesis, and how it is both stored for energy and released as a byproduct.Oxygen is responsible for cellular respiration in plants. Learn more about the role of this critical element in photosynthesis, and how it is both stored for energy and released as a byproduct.Oxygen is responsible for cellular respiration in plants. Learn more about the role of this critical element in photosynthesis, and how it is both stored for energy and released as a byproduct.','O','OXYGEN');
/*!40000 ALTER TABLE `nutrients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `auth_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`auth_id`),
  UNIQUE KEY `UK_4a5an83my3ivxrik34slqvit3` (`auth_id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKmdkb25a1tuyll2y08w26gorfr` FOREIGN KEY (`auth_id`) REFERENCES `authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_product` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ercan@ercan.com','$2a$10$Y1O0jkBY72DME24A4eyH7.vh7M3pvfNXYCmSPXd5huZK61WZBAqDy','No Information','ercan');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-22 20:42:30
